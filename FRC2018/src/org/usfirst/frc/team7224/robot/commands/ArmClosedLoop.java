
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 */
public class ArmClosedLoop extends Command {


    public ArmClosedLoop() {
    	 requires(Robot.arm);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		  	 Robot.arm.armSetup();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
     	     double height = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); // height
             Robot.arm.armControl(height);
             SmartDashboard.putNumber("Height", height);
    
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
