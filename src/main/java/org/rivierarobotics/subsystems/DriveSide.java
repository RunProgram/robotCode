package org.rivierarobotics.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSide extends SubsystemBase {
    private final WPI_TalonSRX master;
    private final WPI_TalonSRX slave;

    public DriveSide(int l, int r, boolean b){
        this.master = new WPI_TalonSRX(l);
        this.slave = new WPI_TalonSRX(r);
        slave.setInverted(b);
        master.setInverted(b);
        slave.follow(master);
    }
    public void setPower(double p){
        master.set(p);
    }
}
