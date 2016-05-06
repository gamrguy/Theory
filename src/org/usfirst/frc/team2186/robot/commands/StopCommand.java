
package org.usfirst.frc.team2186.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team2186.robot.Robot;

/**
 *	This is the default command for the drivetrain and launcher subsystems.
 *	It stops the motors while no other commands are queued.
 */
public class StopCommand extends Command {

	Subsystem subsystem;
	
    public StopCommand(Subsystem sub) {
        // Use requires() here to declare subsystem dependencies
        
    	subsystem = sub;
    	requires(subsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(subsystem.getName().equals("DriveSubsystem"))
    		Robot.driveSubsystem.setMotors(0, 0, 0);
    	else if(subsystem.getName().equals("LauncherSubsystem"))
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
