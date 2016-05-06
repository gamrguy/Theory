
package org.usfirst.frc.team2186.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2186.robot.Robot;

/**
 *	This command is used to FIRE! when ready.
 */
public class FireCommand extends Command {

    public FireCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.launcherSubsystem);
        requires(Robot.switchesSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//Don't run this command if not ready (prevents interruption conflicts)
    	if(!Robot.switchesSubsystem.readyToFire())
    		this.cancel();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean ready = Robot.switchesSubsystem.readyToFire();
    	
    	//If robot is ready to fire and the safety switch is pressed, FIRE!
    	//NOTE: Will work interchangeably with the two sets of buttons.
    	//For example, you can press the trigger on the left and
    	//the safety on the right and still fire.
    	if(ready && (Robot.oi.safetyL.get() || Robot.oi.safetyR.get()))
    		Robot.launcherSubsystem.setUnwinding();
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
