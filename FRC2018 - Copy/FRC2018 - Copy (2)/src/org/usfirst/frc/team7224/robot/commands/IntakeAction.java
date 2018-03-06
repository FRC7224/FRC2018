

package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 *
 */
public class IntakeAction extends Command {


    public IntakeAction() {
    	 requires(Robot.intake);

   }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
  		
    	 Robot.intake.setupIntake();
     }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	if (!RobotConstants.WinchState) { // control is also used for winch
    	     double intakespeed = Robot.chassis.deadZone(Robot.oi.joystick1.getZ()); // forward
    	     if (intakespeed >= RobotConstants.kmaxIntakeSpeed) // limits max forward speed
    	    	 intakespeed = RobotConstants.kmaxIntakeSpeed;
    	     if (intakespeed <= RobotConstants.kminIntakeSpeed ) // limits max reverse speed
    	    	 intakespeed = RobotConstants.kminIntakeSpeed;
    	     Robot.intake.setIntakeMotor(intakespeed);
             SmartDashboard.putNumber("Z Intake", intakespeed);
    	}
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
