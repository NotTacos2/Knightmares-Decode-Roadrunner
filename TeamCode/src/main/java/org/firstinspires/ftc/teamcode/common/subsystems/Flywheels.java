package org.firstinspires.ftc.teamcode.common.subsystems;

import com.bylazar.configurables.annotations.Configurable;
import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.controllable.RunToVelocity;
import dev.nextftc.hardware.powerable.SetPower;
import com.pedropathing.control.PIDFController;
import com.pedropathing.control.PIDFCoefficients;
import dev.nextftc.control.ControlSystem;
import org.firstinspires.ftc.teamcode.common.Parts;

@Configurable
public class Flywheels implements Subsystem {
    public static final Flywheels INSTANCE = new Flywheels();
    private Flywheels() {}

    Parts part = new Parts();

    // TODO: fix this not connecting to the dashboard
    public final double proportionalgain = 0.005;
    public final double velocity = 100.0;
    public final ControlSystem powercontrolled = ControlSystem.builder()
            .velPid(proportionalgain)
            .basicFF(0.003)
            .build();

    // idk if this is good or not
    public final Command off = new RunToVelocity(powercontrolled, 0.0).requires(this);
    public final Command on = new RunToVelocity(powercontrolled, velocity).requires(this);
    public final Command reverse = new RunToVelocity(powercontrolled, -velocity).requires(this);

    @Override
    public void periodic() {
        Parts.flywheel1.setPower(powercontrolled.calculate(Parts.flywheel1.getState()));
        Parts.flywheel2.setPower(powercontrolled.calculate(Parts.flywheel2.getState()));
    }

}

