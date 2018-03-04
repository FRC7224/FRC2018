package org.usfirst.frc.team7224.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousGrpFileGenerator extends CommandGroup{
	
	public AutonomousGrpFileGenerator(){
		
//		addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0, 87, -56, 108.07)); 
//		addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,152,-39, 0)); 
//		addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,140,0, 0)); // drive straight
		addSequential(new AutonomousCmdTrajectoryFollowerFileGenerator(0, 0, 0,211.5,17.1, 45));// rightToScale
		}

}