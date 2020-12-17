package org.rivierarobotics.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import org.rivierarobotics.subsystems.DriveTrain;
import org.rivierarobotics.subsystems.Turret;

public class TurretControl extends CommandBase {
    private final Turret t;
    private final Joystick j1;
    private final DriveTrain d;

    public TurretControl(Turret t, Joystick j1) {
        this.t = t;
        this.j1 = j1;
        d = new DriveTrain();
    }

    public void execute() {
        t.setPower(d.deadBandSet(j1.getX()));
    }
}
