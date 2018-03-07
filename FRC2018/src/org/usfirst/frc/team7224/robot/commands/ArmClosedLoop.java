
package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

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
     	    // Manual adjustment
    	    double height = Robot.chassis.deadZone(Robot.oi.joystick1.getRawAxis(4)); // height
     	    RobotConstants.targetPositionRotations =  RobotConstants.targetPositionRotations +
     	    		(height * RobotConstants.kArmManualSensitivity); 
     	    
     	    
     	   if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.kArmOverideButton)) {
     		   /// This is bad only use in an emergancy 
     		     SmartDashboard.putNumber("Override", RobotConstants.targetPositionRotations);
     		    if (RobotConstants.targetPositionRotations <= RobotConstants.kArmMinHt) 
     		    	 RobotConstants.kArmMinHt =RobotConstants.targetPositionRotations;  // Redefine bottom
          	    if (RobotConstants.targetPositionRotations >= RobotConstants.kArmMaxHt )
          	    	RobotConstants.kArmMaxHt = RobotConstants.targetPositionRotations;  // Redefine top
     	   }  else {
     		   // Button not pressed - Normal mode     	
     	    if (RobotConstants.targetPositionRotations <= RobotConstants.kArmMinHt) 
     	       RobotConstants.targetPositionRotations = RobotConstants.kArmMinHt;  // Limit to zero height
     	    if (RobotConstants.targetPositionRotations >= RobotConstants.kArmMaxHt )
     	       RobotConstants.targetPositionRotations = RobotConstants.kArmMaxHt;  // Limit to max height
     	   }
     	   
     	   
     	   
     	   
     	    // Preset Heights
     	    if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_FieldHTbutton )) {
     		  RobotConstants.targetPositionRotations = RobotConstants.kArm_FieldHT;
     	    }else if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_SwitchHTbutton)) {
     		  RobotConstants.targetPositionRotations = RobotConstants.kArm_SwitchHT;
     	    }else if (Robot.oi.joystick1.getRawButtonPressed(RobotConstants.karm_ScaleHTbutton)) {
     		  RobotConstants.targetPositionRotations = RobotConstants.kArm_ScaleHT;
     	    }
     	    
     	    
     	   if (Robot.oi.joystick1.getRawButton(RobotConstants.kArmOverideButton) && 
     			  Robot.oi.joystick1.getRawButton(RobotConstants.kzeroResetbutton)) {
     		   // This is bad... something went wrong ...  emergency reset
     //		  SmartDashboard.putNumber("RESSEEEEEEEE", RobotConstants.targetPositionRotations);
     		  Robot.arm.armPosReset();
     	   }
     	    
     	  
     	    Robot.arm.armControl();
      //      SmartDashboard.putNumber("Height", height);
      //      SmartDashboard.putNumber("Target Arm Position", RobotConstants.targetPositionRotations);

            
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
