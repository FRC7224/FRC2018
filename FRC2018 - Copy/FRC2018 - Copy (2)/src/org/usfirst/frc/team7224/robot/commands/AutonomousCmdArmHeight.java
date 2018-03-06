package org.usfirst.frc.team7224.robot.commands;
import org.usfirst.frc.team7224.robot.Robot;
import org.usfirst.frc.team7224.robot.RobotConstants;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCmdArmHeight extends Command {

	boolean State;

	public AutonomousCmdArmHeight(double height) {
		requires(Robot.arm);
		RobotConstants.targetPositionRotations = height;
	}

	@Override
	protected void initialize() {
		Robot.arm.armControl();
	}

	@Override
	protected void execute() {
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
		end();
	}

}
