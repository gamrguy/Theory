
package org.usfirst.frc.team2186.robot.subsystems;

import org.usfirst.frc.team2186.robot.RobotMap;
import org.usfirst.frc.team2186.robot.commands.StopCommand;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	This is the subsystem for Theory's drivetrain.
 *	It handles movement of the motors according to the set max speed.
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon frontLeft, frontRight, rearLeft, rearRight;
	RobotDrive drive;
	
	public DriveSubsystem()
	{
		super();
		
		frontLeft = new Talon(RobotMap.frontLeftMotor);
		frontRight = new Talon(RobotMap.frontRightMotor);
		rearLeft = new Talon(RobotMap.backLeftMotor);
		rearRight = new Talon(RobotMap.backRightMotor);
		
		drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
    	drive.setInvertedMotor(MotorType.kFrontLeft, true);
    	drive.setInvertedMotor(MotorType.kRearLeft, true);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopCommand(this));
    }
    
    public void setMotors(double x, double y, double rot)
    {
    	double max_speed = Preferences.getInstance().getDouble("MaxSpeed", 1.0);
    	drive.mecanumDrive_Cartesian(x *max_speed, y *max_speed, rot *max_speed, 0);
    }
}

