// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc7224.FRC2018.subsystems;

import org.usfirst.frc7224.FRC2018.RobotMap;
import org.usfirst.frc7224.FRC2018.commands.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder; 
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput; 
import edu.wpi.first.wpilibj.Timer;
import org.usfirst.frc7224.FRC2018.RobotConstants;
/**
 *
 */
public class Chassis extends PIDSubsystem {


    private final WPI_TalonSRX right1 = RobotMap.chassisTalonSRX1;
    private final WPI_TalonSRX right2 = RobotMap.chassisTalonSRX2;    
    private final WPI_TalonSRX right3 = RobotMap.chassisTalonSRX3;
      
 
    private final WPI_TalonSRX left1 = RobotMap.chassisTalonSRX4;
    private final WPI_TalonSRX left2 = RobotMap.chassisTalonSRX5;
    private final WPI_TalonSRX left3 = RobotMap.chassisTalonSRX6;
    
    
	private final ADXRS450_Gyro gyro = RobotMap.spiGyro_1;


	private final Encoder leftEncoder = RobotMap.leftEncoder;
	private final Encoder rightEncoder = RobotMap.rigthEncoder;

	private boolean turning = true;
	Timer setPointTimer = new Timer();


	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new ChassisTeleopDrive());
	}


    // Initialize your subsystem here
    public Chassis() {
    	    		super("Drivetrain", RobotConstants.Kp, RobotConstants.Ki, RobotConstants.Kd);
    // 		public PIDSubsystem(java.lang.String name, double p,
    //	                    double i,
    //	                    double d)
    		setAbsoluteTolerance(RobotConstants.gyroPIDErrorTolerance);
    		getPIDController().setContinuous(true);
    		getPIDController().setInputRange(-180, 180);
    		getPIDController().setOutputRange(-1.0, 1.0);
    		resetEncoders();
    		gyro.calibrate();
         	}
   
      protected double returnPIDInput() {
		// Used - in code to create PID thread
		// Return your input value for the PID loop
		return gyro.getAngle();
    } 
         
   	protected void usePIDOutput(double output) { // Get PID Output value
    		// NOT Used - in code to create PID thread
    		// Use output to drive your system, like a motor
   		RobotConstants.gyroPIDOutput = output;
   	}
    
    public void disablePID() {
		if (getPIDController().isEnabled()) {
			getPIDController().reset(); // disables and resets integral
		}
	}

	public void enablePID() {
		if (!getPIDController().isEnabled()) {
			gyro.reset();
			getPIDController().enable();
			setSetpoint(0.0);
		}
	}
    
		public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	    }
 
 
    
 // setup
 	public void setupDrive() {

        left2.set(ControlMode.PercentOutput,0);
 		left1.follow(left2);
 		left3.follow(left2);

 		right2.set(ControlMode.PercentOutput,0);
 		right1.follow(right2);
 		right3.follow(right2);

 		gyro.reset();
 		getPIDController().setSetpoint(0); // make setpoint current angle
 		getPIDController().enable();
 		
 		brakemode (false);

 	}

 	public void brakemode(boolean brakemode) {
 		if (brakemode) {
 		 	left1.setNeutralMode( NeutralMode.Brake);	
 	 	 	left2.setNeutralMode( NeutralMode.Brake);	
 	 	 	left3.setNeutralMode( NeutralMode.Brake);
 	 		right1.setNeutralMode(NeutralMode.Brake);	
 	 		right2.setNeutralMode(NeutralMode.Brake);	
 	 		right3.setNeutralMode( NeutralMode.Brake);
 			} else
 		    {
 			left1.setNeutralMode( NeutralMode.Coast);	
 	 		left2.setNeutralMode( NeutralMode.Coast);	
 	 		left3.setNeutralMode( NeutralMode.Coast);	
 	 		right1.setNeutralMode( NeutralMode.Coast);	
 	 		right2.setNeutralMode( NeutralMode.Coast);	
 	 		right3.setNeutralMode( NeutralMode.Coast);	
 		    }
 	 	}
 	
 	
	public double deadZone(double input) {
		double d = Math.abs(input);
		if (d < RobotConstants.DEADZONE) {
			return 0.0;
		}
		return input;
	}
 	
 	public void arcadeDrive(double forward, double turn) {

		if (RobotConstants.enablePID == true) { // use PID process
			// **********************************************************
			// *   PID Proccessing  
			// *
			// **********************************************************
			// 
			if (turn == 0.0) {  //  *** Not turning  ****
				if (turning == true) { // Code is called first time, when we stopped turning
					setPointTimer.start();
					RobotConstants.gyroPIDOutput = 0.0; // Reset PIDOutput to zero
					turning = false; // Set turning to false, because we are not
									 // turning any more
				} else if (setPointTimer.get() != 0) {// If this isn't the first time
					if (setPointTimer.get() >= 1.0) { // Robot is moving straight
												      // wait for timer before turning on PID
						enablePID();
						gyro.reset();
						getPIDController().setSetpoint(0);
						setPointTimer.stop();
						setPointTimer.reset();
					}
				} else { // after initializing ** Driving straight using PID
					turn = RobotConstants.gyroPIDOutput;
				}
				// ELSE the user is still commanding
				// User is commanding a turn
			} else if (turn != 0.0) {
				disablePID();
				setPointTimer.stop();
				setPointTimer.reset();
				turning = true;
				// Reset angle
			}
			displayChasisData();
			arcade(forward, turn); // PID controlled Drive
		} // End of BasicDrive PID Control
		// ELSE PID is Off
		else { // use standard arcadeDrive
			   // *  PID off mode *****
			displayChasisData();
			arcade(forward, turn);
		}
	   } // End of PID enable loop\
 	
	
	public void displayChasisData() {
		// These are the new encoders
//		SmartDashboard.putNumber("LEFT ENCODER", leftEncoder.get());
//		SmartDashboard.putNumber("RIGTH ENCODER", rightEncoder.get());
		SmartDashboard.putNumber("Chassis angle", gyro.getAngle());
		SmartDashboard.putNumber("Chassis gyro setpoint", getSetpoint());
		SmartDashboard.putNumber("Chassis gyro error", getPIDController().getError());
		SmartDashboard.putNumber("Chassis turn", RobotConstants.gyroPIDOutput);
	}
	
	
	
	public void setLeftRightMotorOutputs(double leftOutput, double rightOutput) {
		left2.set(limit(leftOutput));
		right2.set(limit(-rightOutput));
		// SmartDashboard.putNumber("right output ",limit(-rightOutput) );
		// SmartDashboard.putNumber("left output ",limit(leftOutput) );
		// System.out.println("******************************* left **** " +
		// limit(leftOutput));
		// System.out.println("******************************* right **** " +
		// limit(-rightOutput));
	}
 	
	/*********************************************************************************
	 * Method to check if input is in range

	 */
	protected static double limit(double number) {
		if (number >= 1.0) {
			return 1.0;
		} else if (number <= -1.0) {
			return -1.0;
		}
		return number;
	}
	
	
	/**
	 * Simple method to drive the robot like a tank

	 */
	public void tankDrive(double leftValue, double rightValue) {

		/**
		 * boolean squaredInputs = false; leftValue = limit(leftValue);
		 * rightValue = limit(rightValue); if (squaredInputs) { leftValue *=
		 * leftValue; } else { leftValue = -(leftValue * leftValue); } if
		 * (rightValue >= 0.0D) { rightValue *= rightValue; } else { rightValue
		 * = -(rightValue * rightValue); }
		 */
		setLeftRightMotorOutputs(leftValue, rightValue);
	}

	/**
	 * More advanced method to control the robot with just one joystick
	 */

	public void arcade(double moveValue, double rotateValue) {

		boolean squaredInputs = false;
		moveValue = limit(moveValue);
		rotateValue = limit(rotateValue);
		if (squaredInputs) {
			if (moveValue >= 0.0D) {
				moveValue *= moveValue;
			} else {
				moveValue = -(moveValue * moveValue);
			}

			if (rotateValue >= 0.0D) {
				rotateValue *= rotateValue;
			} else {
				rotateValue = -(rotateValue * rotateValue);
			}
		}

		double rightMotorSpeed;
		double leftMotorSpeed;

		if (moveValue > 0.0D) {
			if (rotateValue > 0.0D) {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = Math.max(moveValue, rotateValue);
			} else {
				leftMotorSpeed = Math.max(moveValue, -rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			}
		} else {

			if (rotateValue > 0.0D) {
				leftMotorSpeed = -Math.max(-moveValue, rotateValue);
				rightMotorSpeed = moveValue + rotateValue;
			} else {
				leftMotorSpeed = moveValue - rotateValue;
				rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
			}
		}

		setLeftRightMotorOutputs(leftMotorSpeed, rightMotorSpeed);
	}

}

 	
 	

