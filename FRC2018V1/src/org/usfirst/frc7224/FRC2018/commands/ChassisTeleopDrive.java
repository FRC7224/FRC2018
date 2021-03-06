
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
