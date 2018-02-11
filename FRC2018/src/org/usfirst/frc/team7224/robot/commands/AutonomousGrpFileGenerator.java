package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpFileGenerator extends CommandGroup{
	
	public AutonomousGrpFileGenerator(){
		
		addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0, 87, -56, 108.07)); 

		}

}