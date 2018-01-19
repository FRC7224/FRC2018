// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc7224.FRC2018;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Solenoid pneumaticsSolenoid1;
    public static Solenoid pneumaticsSolenoid2;
    public static Compressor pneumaticsCompressor1;

  
    public static WPI_TalonSRX chassisTalonSRX6;
    public static WPI_TalonSRX chassisTalonSRX5;   
    public static WPI_TalonSRX chassisTalonSRX4;
    public static WPI_TalonSRX chassisTalonSRX3;
    public static WPI_TalonSRX chassisTalonSRX2;
    public static WPI_TalonSRX chassisTalonSRX1;

    public static WPI_TalonSRX armTalonSRX7;
    public static WPI_TalonSRX winchTalonSRX8;
    public static WPI_TalonSRX intakeTalonSRX9;
    public static WPI_TalonSRX intakeTalonSRX10; 
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        pneumaticsSolenoid1 = new Solenoid(0, 0);    
        pneumaticsSolenoid2 = new Solenoid(0, 1);        
        pneumaticsCompressor1 = new Compressor(0);      
        chassisTalonSRX6 = new WPI_TalonSRX(6);
        chassisTalonSRX4 = new WPI_TalonSRX(4);
        chassisTalonSRX5 = new WPI_TalonSRX(5);
        chassisTalonSRX3 = new WPI_TalonSRX(3);
        chassisTalonSRX2 = new WPI_TalonSRX(2);          
        chassisTalonSRX1 = new WPI_TalonSRX(1);

        armTalonSRX7 = new WPI_TalonSRX(7);
        winchTalonSRX8 = new WPI_TalonSRX(8);
        intakeTalonSRX9 = new WPI_TalonSRX(9);
        intakeTalonSRX10 = new WPI_TalonSRX(10);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}