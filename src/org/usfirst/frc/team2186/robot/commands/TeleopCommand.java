
package org.usfirst.frc.team2186.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2186.robot.Robot;

/**
 *	This command drives the robot according to dual joystick input.
 *	Drive method used is mecanum drive (as this is Theory's configuration).
 */
public class TeleopCommand extends Command {
	
    public TeleopCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double x = Robot.oi.left.getRawAxis(0);
    	double y = Robot.oi.left.getRawAxis(1);
    	double rot = Robot.oi.right.getRawAxis(0);
    	Robot.driveSubsystem.setMotors(x, y, rot);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Failsafe
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
