// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc7224.FRC2018.commands;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc7224.FRC2018.Robot;
import org.usfirst.frc7224.FRC2018.RobotConstants;

/**
 *
 */
public class ChassisTeleopDrive extends Command {


    public ChassisTeleopDrive() {
    	 requires(Robot.chassis);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		
    	 Robot.chassis.setupDrive();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	     double forward = Robot.chassis.deadZone(Robot.oi.joystick1.getY()); // forward
             double turn = Robot.chassis.deadZone(Robot.oi.joystick1.getX()); // turn
             Robot.chassis.arcadeDrive(forward, turn);
             Robot.chassis.displayChasisData();
     		SmartDashboard.putNumber("Y", forward);
    		SmartDashboard.putNumber("X", turn);

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
