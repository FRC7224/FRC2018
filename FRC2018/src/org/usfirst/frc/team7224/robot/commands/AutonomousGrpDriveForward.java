package org.usfirst.frc.team7224.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class AutonomousGrpDriveForward extends CommandGroup {

    public AutonomousGrpDriveForward() {
 		addSequential(new AutonomousCmdTrajectoryFollowerTwoFixFile(0));
 	  }

}
