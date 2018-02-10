package org.usfirst.frc.team7224.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousDriveForward extends CommandGroup {

    public AutonomousDriveForward() {
 	//   addSequential(new AutonomousTrajectoryFollowerTwoPointGear(0,0,0, 100, 0, 0, true));
 		addSequential(new AutonomousTrajectoryFollowerTwoPointFixMoveFile(4, true, 3.5));
 	  }

}
