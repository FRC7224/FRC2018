package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomousGrpLeftAutoSelect extends CommandGroup{
	
	public AutonomousGrpLeftAutoSelect(){
		   // Starting in Left position
	    addSequential(new AutonomousCmdClaw(true)); // open claw 
 //       addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0, 87, -56, 108.07, true)); 

		}

}