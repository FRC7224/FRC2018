package org.usfirst.frc.team7224.robot.commands;



import org.usfirst.frc.team7224.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class AutonomousCmdSimpleDrive extends Command {

	double power;
	double drivetime;
	Timer timeout;

	/**
	 * starts a command that drives robot for a specific amount of time
	 * 
	 * @param motorpower
	 *            the motor power to drive from -1.0 to 1.0
	 * @param time
	 *            how long to drive in seconds
	 */
	public AutonomousCmdSimpleDrive (double motorpower, double time) {
		power = motorpower;
		drivetime = time;
		requires(Robot.chassis);
	}

	@Override
	protected void initialize() {
		timeout = new Timer();
		Robot.chassis.setupDrive();
	}

	@Override
	protected void execute() {
		Robot.chassis.displayChasisData();
		Robot.chassis.arcadeDrive(power, 0);
	}

	@Override
	protected boolean isFinished() {
		if (timeout.get() > drivetime) 
			return true;		
		else
		    return false;
	}

	@Override
	protected void end() {
		Robot.chassis.arcadeDrive(0, 0);
	}

	@Override
	protected void interrupted() {
		end();
	}

}
