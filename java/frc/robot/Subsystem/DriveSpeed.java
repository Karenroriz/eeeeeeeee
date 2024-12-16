package frc.robot.Subsystem;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class DriveSpeed extends SubsystemBase{

    private CANSparkMax[] speedMotors = new CANSparkMax[Constants.CAN_MS.length];
    private double uniSpd = 0;

    public DriveSpeed() {
        for(int i = 0; i < speedMotors.length; i++) {
            speedMotors[i] = new CANSparkMax(Constants.CAN_MS[i], MotorType.kBrushless);
            if(i != 0)
                speedMotors[i].follow(speedMotors[i-1]);
        }
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("SpeedMotors power", uniSpd);
    }

    public void setMSPower(double spd){
        for(CANSparkMax motor : speedMotors)
            motor.set(spd);
        uniSpd = spd;
    }
}
