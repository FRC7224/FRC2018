


package org.usfirst.frc7224.FRC2018;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder; 
import edu.wpi.first.wpilibj.DigitalInput;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Solenoid pneumaticsSolenoid1 = new Solenoid(0, 0); 
    public static Solenoid pneumaticsSolenoid2  = new Solenoid(0, 1); 
    public static Compressor pneumaticsCompressor1 = new Compressor(0);
   
    
/*    
    public static WPI_TalonSRX chassisTalonSRX6 = new  WPI_TalonSRX(6);
    public static WPI_TalonSRX chassisTalonSRX5  = new WPI_TalonSRX(5); 
    public static WPI_TalonSRX chassisTalonSRX4 = new WPI_TalonSRX(4);
    public static WPI_TalonSRX chassisTalonSRX3 = new WPI_TalonSRX(3);
    public static WPI_TalonSRX chassisTalonSRX2 = new WPI_TalonSRX(2);
    public static WPI_TalonSRX chassisTalonSRX1 = new WPI_TalonSRX(1);
*/
    
/*    public static WPI_TalonSRX armTalonSRX7 = new WPI_TalonSRX(7);
    public static WPI_TalonSRX winchTalonSRX8  = new WPI_TalonSRX(8);
    public static WPI_TalonSRX intakeTalonSRX9= new WPI_TalonSRX(9);
    public static WPI_TalonSRX intakeTalonSRX10  = new WPI_TalonSRX(10); */
	public static Encoder rigthEncoder = new Encoder(new DigitalInput(0), new DigitalInput(1), false, Encoder.EncodingType.k4X);
	public static Encoder leftEncoder = new Encoder(new DigitalInput(2), new DigitalInput(3), true, Encoder.EncodingType.k4X);
    public static ADXRS450_Gyro spiGyro_1  = new ADXRS450_Gyro();
  
}