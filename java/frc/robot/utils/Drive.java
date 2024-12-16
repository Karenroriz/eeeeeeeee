package frc.robot.utils;

public class Drive {
    public static double getAngleDistance(double x, double y){
        return 1/(Math.tan(y));
    }
}
