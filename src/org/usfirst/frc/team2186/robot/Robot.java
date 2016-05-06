
package org.usfirst.frc.team2186.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2186.robot.commands.TeleopCommand;
import org.usfirst.frc.team2186.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team2186.robot.subsystems.LauncherSubsystem;
import org.usfirst.frc.team2186.robot.subsystems.SwitchesSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final DriveSubsystem driveSubsystem = new DriveSubsystem();
	public static final LauncherSubsystem launcherSubsystem = new LauncherSubsystem();
	public static final SwitchesSubsystem switchesSubsystem = new SwitchesSubsystem();
	public static OI oi;

    Command teleopCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		teleopCommand = new TeleopCommand();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Here there was switch code.
	 * Now there is not, and will not.
	 * My haiku is bad.
	 */
    public void autonomousInit() {
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	teleopCommand.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        if(switchesSubsystem.readyToFire()) {
    		SmartDashboard.putString("DB/String "+0, "ready to fire");
    	} else {
    		SmartDashboard.putString("DB/String "+0, "reloading");
    	}
        
        SmartDashboard.putString("DB/String "+1, "Wound switch: " + switchesSubsystem.isBarDown());
    	SmartDashboard.putString("DB/String "+2, "Taut switch: " + switchesSubsystem.isTaut());
    	SmartDashboard.putString("DB/String "+3, "Fired switch: " + switchesSubsystem.isLauncherFired());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
