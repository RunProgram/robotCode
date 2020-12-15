package org.rivierarobotics.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private final WPI_TalonSRX turret;
    private double ticksInADegree = 4096/360;
    public Turret(WPI_TalonSRX turret){
        this.turret = turret;
    }
    /*public void setChange(double change){
        ticksInADegree += change;
    }*/
    public void setPositionTicks(double ticks){
        turret.set(ControlMode.MotionMagic, ticks);
    }
    public void setPositionDegrees(double pos){
        setPositionTicks(pos * ticksInADegree);
    }
    public double getPositionTicks(){
        return turret.getSelectedSensorPosition();
    }
    public double getPositionDegrees(){
        double degrees = turret.getSelectedSensorPosition()/ticksInADegree;
        return degrees;
    }
}
