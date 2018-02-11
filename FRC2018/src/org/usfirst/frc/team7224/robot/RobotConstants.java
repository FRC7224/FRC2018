package org.usfirst.frc.team7224.robot;


/**
 * This class contains all the variables and constants used by the developers for the robot.
 *
 * 
 */

public class RobotConstants {

	// IMPORTANT NOTICE
	//
	// Please make sure, that all the constants you insert here, are in the
	// right area. If no matches, you create your own one.
	
	
	// Joystick 1 constants
	public static double kdeadzone = 0.1; // updated by MG
	public static int kclawbutton = 1;
	public static int kshiftbutton = 2;
	public static int karm_FieldHTbutton = 5;
	public static int karm_SwitchHTbutton = 6;
	public static int karm_ScaleHTbutton = 7; 
	public static int kWinchButtonA = 9;
	public static int kWinchButtonB = 10;
	
	// Chassis 
	public static boolean kenablePID = true;
	public static double Kp = 0.005; //.005 0.012
	public static double Ki = 0.0; //.1 0.0025
	public static double Kd = 0.1;  // .1
	public static double kgyroPIDErrorTolerance = 1.0; // in degrees
	public static double gyroPIDOutput = 0.0;
	public static double kshiftRateUp = 1200;
	public static double kshiftRateDown = 800;
	public static boolean shiftOpenState = false;
	
	// Arm 
	public static final int kSlotIdx = 0;
	public static final int kallowableCloseLoopError = 100;
	public static final int kPIDLoopIdx = 0;
	public static final int kTimeoutMs = 10;
	public static final double kMaxSpeed = 0.2;
	public static final double kStopSpeed = 0.0;
	public static double targetPositionRotations;
	public static double kArmManualSensitivity = 500;
	public static double kArm_FieldHT = 1000;
	public static double kArm_SwitchHT = 20000;
	public static double kArm_ScaleHT = 100000; 
	public static double kArmMinHt = 0;
	public static double kArmMaxHt = 500000;
	public static double kArmPIDF = 0.0;
	public static double kArmPIDP = 0.1;
	public static double kArmPIDI = 0.00005;
	public static double kArmPIDD = 0.0;
	
		
	// Claw 
	public static boolean clawOpenState = false;
	public static double kclawcloseTimer_timer = .3;

	// Autonomous 
	public static int TrajectorySegments;
	public static boolean isTrajectory = false;
	public static int kencodermode = 1;

	// Winch 
	public static double kmaxWinchSpeed = 0.2;
	public static double kminWinchSpeed = 0.0;
	public static boolean WinchState = false;
	
	// Intake 
	public static double kmaxIntakeSpeed =  0.2;
	public static double kminIntakeSpeed = -0.2;
	
	// Driverstation
	public static String gameData = "XXX";
	
	// Shifter
	public static double kcloseTimer_timer = .3;

	
}
	