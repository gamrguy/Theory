
package org.usfirst.frc.team2186.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2186.robot.Robot;

/**
 *	This command tells the robot to wind the mechanism properly.
 */
public class WindCommand extends Command {

    public WindCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.launcherSubsystem);
        requires(Robot.switchesSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Prevents command from running in inappropriate situations
    	//Also prevents interruption conflicts
    	if(Robot.switchesSubsystem.readyToFire())
    		this.cancel();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//If bar isn't down yet, wind normally
    	if(!Robot.switchesSubsystem.isBarDown())
    		Robot.launcherSubsystem.setWinding();
    	//If bar is down, and mechanism isn't taut, start unwinding
    	else if(!Robot.switchesSubsystem.isTaut())
    		Robot.launcherSubsystem.setUnwinding();
    	//If either of these conditions aren't met, do nuffin
    	else
    		Robot.launcherSubsystem.setMotor(0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
