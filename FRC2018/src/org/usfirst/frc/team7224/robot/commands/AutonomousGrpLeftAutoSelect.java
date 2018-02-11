package org.usfirst.frc.team7224.robot.commands;

import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpLeftAutoSelect extends CommandGroup{
	
	public AutonomousGrpLeftAutoSelect(){
		  // Drive to Scale or Switch  
         addSequential(new AutonomousCmdClaw(false)); // Close claw
	     addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(1)); // 1 = Left
	     addSequential(new AutonomousCmdWait(0.5)); // wait 
	     addSequential(new AutonomousCmdClaw(true)); // Open claw
	     addSequential(new AutonomousCmdSimpleDrive(-0.2, 1.0)); // Backup
	     addSequential(new AutonomousCmdArmHeight(RobotConstants.kArm_FieldHT)); // Lower Arm
       }
}