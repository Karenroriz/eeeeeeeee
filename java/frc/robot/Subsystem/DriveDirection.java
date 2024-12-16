package frc.robot.Subsystem;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.utils.Constants;

public class DriveDirection extends SubsystemBase{

    private CANSparkMax[] directionMotors = new CANSparkMax[Constants.CAN_MD.length];
    private CANcoder[] CANcoderMS = new CANcoder[Constants.CANcoderMD_ID.length];
    private double[] abscoders = new double[CANcoderMS.length];
    private double uniSpd = 0;
    private double enzis = 0;

    public DriveDirection() {
        for(int i = 0; i < directionMotors.length; i++) {
            directionMotors[i] = new CANSparkMax(Constants.CAN_MD[i], MotorType.kBrushless);
            CANcoderMS[i] = new CANcoder(Constants.CANcoderMD_ID[i]);
            if(i != 0)
                directionMotors[i].follow(directionMotors[i-1]);
        }
    }

    @Override
    public void periodic(){
        updateAbscoder();
        SmartDashboard.putNumberArray("Abscoder from SPD", abscoders);
        SmartDashboard.putNumber("SpeedMotors power", uniSpd);
        SmartDashboard.putNumber("Cotangent", enzis);

    }

    public void setMDPower(double spd){
        for(CANSparkMax motor : directionMotors)
            motor.set(spd);
        uniSpd = spd;
    }

    public void resetAxis(){
        //Front Left
        if(abscoders[0] > 0.1){
            
        }
    }

    public void updateAbscoder(){
        for (int i = 0; i < CANcoderMS.length; i++) {
            abscoders[i] = CANcoderMS[i].getAbsolutePosition().getValueAsDouble();
        }
    }
}
