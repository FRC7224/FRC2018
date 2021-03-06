/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team7224.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.livewindow.*;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.commands.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team7224.robot.subsystems.Pneumatics;
import org.usfirst.frc.team7224.robot.subsystems.Shifter;
import org.usfirst.frc.team7224.robot.subsystems.Winch;
import org.usfirst.frc.team7224.robot.OI;
import org.usfirst.frc.team7224.robot.commands.AutonomousCmd;
import org.usfirst.frc.team7224.robot.subsystems.Arm;
import org.usfirst.frc.team7224.robot.subsystems.Chassis;
import org.usfirst.frc.team7224.robot.subsystems.Claw;
import org.usfirst.frc.team7224.robot.subsystems.Intake;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	public static final Chassis chassis
	        = new Chassis();
	public static final Arm arm
            = new Arm(); 
	public static final Pneumatics pneumatics
            = new Pneumatics(); 
	public static final Intake intake
	        = new Intake();
    public static final Winch winch
	        = new Winch();
	public static final Claw claw
	        = new Claw();
	public static final Shifter shifter
	        = new Shifter();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser<Command> autoChooser;
	CameraServer server;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		oi = new OI();
	//	Command autonomousCommand;
	//	SendableChooser<Command> autoChooser;
		


		LiveWindow.disableAllTelemetry();
 
        
	      autoChooser = new SendableChooser();

		  autoChooser.addObject("Left Start Auto Select", new AutonomousGrpLeftAutoSelect());
		  autoChooser.addObject("Center Start Auto Select", new AutonomousGrpCenterAutoSelect());
		  autoChooser.addObject("Right Start Auto Select", new AutonomousGrpRightAutoSelect());
	      autoChooser.addObject("xx Do Nothing", new AutonomousCmdDoNothing());
		  autoChooser.addObject("xx Drive Forward", new AutonomousGrpDriveForward());
		  autoChooser.addDefault("xx File Generator", new AutonomousGrpFileGenerator());
		  SmartDashboard.putData("Autonomous mode chooser", autoChooser);
		 
	      server = CameraServer.getInstance();
//		  server.startAutomaticCapture(0);
//		  server.startAutomaticCapture(1);
		  
     	 
	}	

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		RobotConstants.gameData = DriverStation.getInstance().getGameSpecificMessage();
		autonomousCommand = autoChooser.getSelected();

		// schedule the autonomous command 
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		Robot.chassis.resetgyro();	
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
