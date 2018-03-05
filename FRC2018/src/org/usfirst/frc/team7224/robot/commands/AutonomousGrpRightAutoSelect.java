package org.usfirst.frc.team7224.robot.commands;

import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousGrpRightAutoSelect extends CommandGroup{
	
	public AutonomousGrpRightAutoSelect(){
		  // Drive to Scale or Switch
   //      addSequential(new AutonomousCmdClaw(false)); // Close claw
         addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(3)); // 3 = Right
	     addSequential(new AutonomousCmdWait(0.5)); // wait 
	     addSequential(new AutonomousCmdClaw(true)); // Open claw
	     addSequential(new AutonomousCmdWait(1.0)); // wait
	     addSequential(new AutonomousCmdSimpleDrive(-0.2,3.0)); // Backup
	     addSequential(new AutonomousCmdWait(1.0)); // wait
	     addSequential(new AutonomousCmdArmHeight(RobotConstants.kArm_FieldHT)); // Lower Arm
      }
    }

