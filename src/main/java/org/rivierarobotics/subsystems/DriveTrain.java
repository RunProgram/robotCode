package org.rivierarobotics.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
    private final DriveSide left;
    private final DriveSide right;
    private final double deadband = 0.1;

    public DriveTrain(){
        this.left = new DriveSide(2, 4, true);
        this.right = new DriveSide(1, 3, false);
    }
    public void setPower(double l, double r){
        left.setPower(deadBandSet(l));
        right.setPower(deadBandSet(r));
    }
    public double deadBandSet(double num){
        if(Math.abs(num) < deadband){
            return 0;
        }
        else return num;
    }
}
