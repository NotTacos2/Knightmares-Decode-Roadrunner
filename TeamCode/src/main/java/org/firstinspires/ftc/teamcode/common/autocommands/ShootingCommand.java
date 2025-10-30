package org.firstinspires.ftc.teamcode.common.autocommands;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;
import org.firstinspires.ftc.teamcode.common.subsystems.Intake;

public class ShootingCommand {
    public ShootingCommand() {
        new SubsystemComponent(Pivot.INSTANCE, Flywheels.INSTANCE, Intake.INSTANCE);
    }

    public Command autoRoutine() {
        return new SequentialGroup(
            Pivot.INSTANCE.reset,
            new ParallelGroup(
                    Flywheels.INSTANCE.on,
                    Intake.INSTANCE.power,
                    Intake.INSTANCE.rotationcon
            ),
            new Delay(5),
            new ParallelGroup(
                    Flywheels.INSTANCE.off,
                    Intake.INSTANCE.stop,
                    Intake.INSTANCE.rotationconstop
            )
        );
    }
}
