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
	/** save the target position to servo to */
	double targetPositionRotations;
	
	
	  public void armSetup() {
			/* lets grab the 360 degree position of the MagEncoder's absolute position */
			int absolutePosition = arm.getSelectedSensorPosition(RobotConstants.kTimeoutMs) & 0xFFF; /* mask out the bottom12 bits, we don't care about the wrap arounds */
	        /* use the low level API to set the quad encoder signal */
	        arm.setSelectedSensorPosition(absolutePosition, RobotConstants.kPIDLoopIdx, RobotConstants.kTimeoutMs);
	        
	        /* choose the sensor and sensor direction */
	        arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotConstants.kPIDLoopIdx, RobotConstants.kTimeoutMs);
	        arm.setSensorPhase(true);
	        
	        /* set the peak and nominal outputs, 12V means full */
	        arm.configNominalOutputForward(0, RobotConstants.kTimeoutMs);
	        arm.configNominalOutputReverse(0, RobotConstants.kTimeoutMs);
	        arm.configPeakOutputForward(1, RobotConstants.kTimeoutMs);
	        arm.configPeakOutputReverse(-1, RobotConstants.kTimeoutMs);
	        /* set the allowable closed-loop error,
	         * Closed-Loop output will be neutral within this range.
	         * See Table in Section 17.2.1 for native units per rotation. 
	         */
	        arm.configAllowableClosedloopError(0, RobotConstants.kPIDLoopIdx, RobotConstants.kTimeoutMs); /* always servo */
	        /* set closed loop gains in slot0 */
	        arm.config_kF(RobotConstants.kPIDLoopIdx, 0.0, RobotConstants.kTimeoutMs);
	        arm.config_kP(RobotConstants.kPIDLoopIdx, 0.1, RobotConstants.kTimeoutMs);
	        arm.config_kI(RobotConstants.kPIDLoopIdx, 0.0, RobotConstants.kTimeoutMs);
	        arm.config_kD(RobotConstants.kPIDLoopIdx, 0.0, RobotConstants.kTimeoutMs);

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
	        	_sb.append(targetPositionRotations);
	        }
	        /* print every ten loops, printing too much too fast is generally bad for performance */ 
	        if(++_loops >= 10) {
	        	_loops = 0;
	        	System.out.println(_sb.toString());
	        }
	        _sb.setLength(0);

	    }
	    public void armControl( double height) {
	    	targetPositionRotations = height * 50.0 * 4096; /* 50 Rotations * 4096 u/rev in either direction */
        	arm.set(ControlMode.Position, targetPositionRotations); /* 50 rotations in either direction */

	   
	    }



	}
