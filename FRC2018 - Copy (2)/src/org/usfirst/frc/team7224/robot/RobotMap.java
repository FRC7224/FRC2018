/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/




package org.usfirst.frc.team7224.robot;



import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.CANTalon;
import com.ctre.phoenix.*;
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
    public static Solenoid pneumaticsSolenoid0 = new Solenoid(0, 0); 
    public static Solenoid pneumaticsSolenoid1  = new Solenoid(0, 1); 
    public static Compressor pneumaticsCompressor = new Compressor(0);
    public static WPI_TalonSRX chassisTalonSRX6 = new  WPI_TalonSRX(6);
/*    public static WPI_TalonSRX chassisTalonSRX5  = new WPI_TalonSRX(5); 
    public static WPI_TalonSRX chassisTalonSRX4 = new WPI_TalonSRX(4);
    public static WPI_TalonSRX chassisTalonSRX3 = new WPI_TalonSRX(3);
    public static WPI_TalonSRX chassisTalonSRX2 = new WPI_TalonSRX(2);
    public static WPI_TalonSRX chassisTalonSRX1 = new WPI_TalonSRX(1);
*/
    public static WPI_VictorSPX chassisTalonSRX5  = new WPI_VictorSPX(5); 
    public static WPI_VictorSPX chassisTalonSRX4 = new WPI_VictorSPX(4);
    public static WPI_VictorSPX chassisTalonSRX3 = new WPI_VictorSPX(3);
    public static WPI_VictorSPX chassisTalonSRX2 = new WPI_VictorSPX(2);
    public static WPI_VictorSPX chassisTalonSRX1 = new WPI_VictorSPX(1);
    public static WPI_TalonSRX armTalonSRX7 = new WPI_TalonSRX(7);
    public static WPI_TalonSRX winchTalonSRX8  = new WPI_TalonSRX(8);
    public static WPI_VictorSPX intakeTalonSRX9= new WPI_VictorSPX(9);
    public static WPI_VictorSPX intakeTalonSRX10  = new WPI_VictorSPX(10); 
	public static Encoder rigthEncoder = new Encoder(new DigitalInput(0), new DigitalInput(1), false, Encoder.EncodingType.k4X);
	public static Encoder leftEncoder = new Encoder(new DigitalInput(2), new DigitalInput(3), true, Encoder.EncodingType.k4X);
    public static ADXRS450_Gyro spiGyro_1  = new ADXRS450_Gyro();
  
}
