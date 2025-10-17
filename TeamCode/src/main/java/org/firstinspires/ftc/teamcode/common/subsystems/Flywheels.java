package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.powerable.SetPower;
import dev.nextftc.control.ControlSystem;
import dev.nextftc.control.KineticState;
import org.firstinspires.ftc.teamcode.common.Parts;

public class Flywheels implements Subsystem {
    public static final Flywheels INSTANCE = new Flywheels();
    private Flywheels() {}

    Parts part = new Parts();

    ControlSystem flywheelsystem = ControlSystem.builder()
            .posPid(0.02, 0, 0.02)
            .build();

    public Command powerone = new SetPower(Parts.flywheel1, 1).requires(this);
    public Command testpowerone = new SetPower(Parts.flywheel1,
            flywheelsystem.calculate(
                    new KineticState(Parts.flywheel1.getCurrentPosition(), Parts.flywheel1.getVelocity())
            )).requires(this);
    public Command powertwo = new SetPower(Parts.flywheel2, 1).requires(this);
    public Command testpowertwo = new SetPower(Parts.flywheel2,
            flywheelsystem.calculate(
                    new KineticState(Parts.flywheel2.getCurrentPosition(), Parts.flywheel2.getVelocity())
            )).requires(this);
    public Command negpowerone = new SetPower(Parts.flywheel1, -1).requires(this);
    public Command negpowertwo = new SetPower(Parts.flywheel2, -1).requires(this);
    public Command stopone = new SetPower(Parts.flywheel1, 0).requires(this);
    public Command stoptwo = new SetPower(Parts.flywheel2, 0).requires(this);
}