
package org.usfirst.frc.team2186.robot.subsystems;

import org.usfirst.frc.team2186.robot.RobotMap;
import org.usfirst.frc.team2186.robot.commands.StopCommand;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * The subsystem for the launcher mechanism.
 * Controls how the launcher moves.
 */
public class LauncherSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Talon launcher;
	
	public LauncherSubsystem()
	{
		super();
		
		launcher = new Talon(RobotMap.launcherMotor);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new StopCommand(this));
    }
    
    public void setMotor(double speed)
    {
    	launcher.set(speed);
    }
    
    public void setWinding()
    {
    	double speed = Preferences.getInstance().getDouble("LauncherSpeed", 1.0);
    	launcher.set(speed);
    }
    
    public void setUnwinding()
    {
    	double speed = Preferences.getInstance().getDouble("LauncherSpeed", 1.0);
    	launcher.set(-speed);
    }
}

