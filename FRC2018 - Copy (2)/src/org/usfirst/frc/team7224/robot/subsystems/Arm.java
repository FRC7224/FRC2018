package org.usfirst.frc.team7224.robot.subsystems;
import org.usfirst.frc.team7224.robot.RobotConstants;
import org.usfirst.frc.team7224.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;



import org.usfirst.frc.team7224.robot.commands.*;

public class Arm extends Subsystem {
	private final WPI_TalonSRX arm = RobotMap.armTalonSRX7;
	StringBuilder _sb = new StringBuilder();
	int _loops = 0;

	
	
	  public void armSetup() {
			/* lets grab the 360 degree position of the MagEncoder's absolute position */
			int absolutePosition = arm.getSelectedSensorPosition(RobotConstants.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
	        /* use the low level API to set the quad encoder signal */
	        arm.setSelectedSensorPosition(absolutePosition, RobotConstants.kPIDLoopIdx, RobotConstants.kTimeoutMs);
	        
	        /* choose the sensor and sensor direction */
	        arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotConstants.kPIDLoopIdx, RobotConstants.kTimeoutMs);
	        arm.setSensorPhase(true);
	       
	        
	        /* set the peak and nominal output */
	        arm.configNominalOutputForward(RobotConstants.kStopSpeed, RobotConstants.kTimeoutMs);
	        arm.configNominalOutputReverse(RobotConstants.kStopSpeed, RobotConstants.kTimeoutMs);
	        arm.configPeakOutputForward(RobotConstants.kMaxSpeed, RobotConstants.kTimeoutMs);
	        arm.configPeakOutputReverse(-RobotConstants.kMaxSpeed, RobotConstants.kTimeoutMs);
	        /* set the allowable closed-loop error,
	         * Closed-Loop output will be neutral within this range.
	         * See Table in Section 17.2.1 for native units per rotation. 
	         * 
	         */
	        arm.configAllowableClosedloopError( RobotConstants.kPIDLoopIdx,RobotConstants.kallowableCloseLoopError, RobotConstants.kTimeoutMs); /* always servo */
	        /* set closed loop gains in slot0 */
	        arm.config_kF(RobotConstants.kPIDLoopIdx,RobotConstants.kArmPIDF, RobotConstants.kTimeoutMs);
	        arm.config_kP(RobotConstants.kPIDLoopIdx, RobotConstants.kArmPIDP, RobotConstants.kTimeoutMs);
	        arm.config_kI(RobotConstants.kPIDLoopIdx, RobotConstants.kArmPIDI, RobotConstants.kTimeoutMs);
	        arm.config_kD(RobotConstants.kPIDLoopIdx, RobotConstants.kArmPIDD, RobotConstants.kTimeoutMs);

	        RobotConstants.targetPositionRotations = 0; // reset on startup crate height
	    }

	  @Override
	    public void initDefaultCommand() {
			// Set the default command for a subsystem here.
			setDefaultCommand(new ArmClosedLoop());
	    }

	    @Override
	    public void periodic() {

	        /* if Talon is in position closed-loop, print some more info */
	        if( arm.getControlMode() == ControlMode.Position) {
	        	/* append more signals to print when in speed mode. */
	        	_sb.append("\terrNative:");
	        	_sb.append(arm.getClosedLoopError(0));
	        	_sb.append("\ttrg:");
	        	_sb.append(RobotConstants.targetPositionRotations);
	        	
	        }
	        /* print every ten loops, printing too much too fast is generally bad for performance */ 
	        if(++_loops >= 10) {
	        	_loops = 0;
	        	System.out.println(_sb.toString());
	        }
	        _sb.setLength(0);

	    }
	    public void armControl() {
	    	arm.set(ControlMode.Position, RobotConstants.targetPositionRotations); 
 
	    }

	}
