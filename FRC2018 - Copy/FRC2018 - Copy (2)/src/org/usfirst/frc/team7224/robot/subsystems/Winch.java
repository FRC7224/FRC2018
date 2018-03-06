package org.usfirst.frc.team7224.robot.subsystems;
import org.usfirst.frc.team7224.robot.RobotMap;
import org.usfirst.frc.team7224.robot.commands.WinchAction;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
/**
*
*/
public class Winch extends Subsystem {


   private final WPI_TalonSRX winchmotor = RobotMap.winchTalonSRX8;


   public void initDefaultCommand() {
       setDefaultCommand(new WinchAction());
   }

   public void setupWinch() {
	   winchmotor.set(ControlMode.PercentOutput,0);
   }

   /**
    * sets the ball motor speed  -1 to +1
    */
   public void setWinchSpeed(double wspeed) {
	   winchmotor.set(wspeed);
	   }
}
   
