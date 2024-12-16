package frc.robot.Commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveDirection;
import frc.robot.Subsystem.DriveSpeed;

public class DriverCommand extends Command{
    DriveSpeed driveMS;
    DriveDirection driveMD;
    GenericHID joystick;

    public DriverCommand(DriveSpeed driveMS, DriveDirection driveMD, GenericHID joystick){
        this.joystick = joystick;
        this.driveMS = driveMS;
        this.driveMD = driveMD;
        addRequirements(driveMS, driveMD);
    }

    

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    
}
