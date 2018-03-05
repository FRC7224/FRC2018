package org.usfirst.frc.team7224.robot.subsystems;


import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.ClawAction;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;



/**
 *
 */
public class Claw extends Subsystem {


    private final Solenoid OpenCloseClaw = RobotMap.pneumaticsSolenoid1;


      public void initDefaultCommand() {
       setDefaultCommand(new ClawAction());
    }

        public void openClaw() {
        //
        // opens claw
        	OpenCloseClaw.set(true);
    }

    public void closeClaw() {
        //
        // closes claw
    	   OpenCloseClaw.set(false);
    }
}
