package org.usfirst.frc.team2186.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	//JOYSTICKS
	public static int leftJoystick = 0;
	public static int rightJoystick = 1;
	
	//BUTTONS
	public static int windButton = 3;
	public static int fireButton = 1;
	public static int safeButton = 2;
	
	//MOTORS
	public static int frontRightMotor = 1;
	public static int frontLeftMotor = 0;
	public static int backRightMotor = 3;
	public static int backLeftMotor = 2;
	public static int launcherMotor = 4;
	
	//LIMIT SWITCHES
	public static int firedSwitch = 7;
	public static int tautSwitch = 9;
	public static int barDownSwitch = 8;
}
