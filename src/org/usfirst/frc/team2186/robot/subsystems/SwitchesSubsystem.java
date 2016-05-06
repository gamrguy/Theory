
package org.usfirst.frc.team2186.robot.subsystems;

import org.usfirst.frc.team2186.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	This subsystem handles limit switch input.
 */
public class SwitchesSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DigitalInput firedSwitch, tautSwitch, barDownSwitch;
	
	public SwitchesSubsystem()
	{
		super();
		
		firedSwitch = new DigitalInput(RobotMap.firedSwitch);
		tautSwitch = new DigitalInput(RobotMap.tautSwitch);
		barDownSwitch = new DigitalInput(RobotMap.barDownSwitch);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    //Returns whether the fired switch is active
    public boolean isLauncherFired()
    {
    	return !firedSwitch.get();
    }
    
    //Returns whether the mechanism is taut and ready to launch
    public boolean isTaut()
    {
    	return !tautSwitch.get();
    }
    
    //Returns whether the bar is currently in the down position
    public boolean isBarDown()
    {
    	return !barDownSwitch.get();
    }
    
    public boolean readyToFire()
    {
    	return (!isLauncherFired() && isTaut() && isBarDown());
    }
}

