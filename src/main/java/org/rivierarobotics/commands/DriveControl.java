package org.rivierarobotics.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.subsystems.DriveTrain;

public class DriveControl extends CommandBase {
    private final DriveTrain d;
    private final Joystick l;
    private final Joystick r;

    public DriveControl(DriveTrain d, Joystick l, Joystick r){
        this.d = d;
        this.l = l;
        this.r = r;
        addRequirements(d);
    }

    @Override
    public void execute() {
        d.setPower(l.getY(), r.getY());
    }
}
