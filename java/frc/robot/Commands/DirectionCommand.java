package frc.robot.Commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystem.DriveDirection;

public class DirectionCommand extends Command{
    DriveDirection driveMD;
    DoubleSupplier xAxis;

    public DirectionCommand(DoubleSupplier x, DriveDirection driveMD){
        this.xAxis = x;
        this.driveMD = driveMD;
        addRequirements(driveMD);
    }

    

    @Override
    public void initialize() {
        super.initialize();
    }

    @Override
    public void execute() {
        driveMD.setMDPower(xAxis.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        driveMD.setMDPower(0);
    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }

    
}
