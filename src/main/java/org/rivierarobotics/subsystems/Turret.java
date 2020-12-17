package org.rivierarobotics.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private final WPI_TalonSRX turret;
    private double ticksInADegree = 4096.0/360.0;
    private double offset = 100/ticksInADegree;
    public Turret(WPI_TalonSRX turret){
        this.turret = turret;
    }
    /*public void setChange(double change){
        ticksInADegree += change;
    }*/
    public void setPositionTicks(double ticks){
        if(ticks/ticksInADegree >= -45 || ticks/ticksInADegree <= 45){
            turret.set(ControlMode.MotionMagic, ticks);
        }
        else{
            turret.set(30);
        }
    }
    public void setPositionDegrees(double pos){
        if(pos >= -45 || pos <= 45){
            double ticks = (ticksInADegree*(pos + offset)) % 4096;
            turret.set(ControlMode.MotionMagic, ticks);
        }
        else{
            turret.set(30);
        }
    }
    public double getPositionTicks(){
        return turret.getSelectedSensorPosition();
    }
    public double getPositionDegrees(){
        double degrees = turret.getSelectedSensorPosition()/ticksInADegree;
        return degrees;
    }
}
