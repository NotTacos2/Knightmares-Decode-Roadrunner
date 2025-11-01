package org.firstinspires.ftc.teamcode.common.autocommands;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.common.subsystems.Intake;

public class IntakeCommand {
    public IntakeCommand() {
        new SubsystemComponent(Intake.INSTANCE);
    }

    public Command autoRoutine() {
        return new SequentialGroup(
                new ParallelGroup(
                        Intake.INSTANCE.power,
                        Intake.INSTANCE.rotationcon
                ),
                new Delay(3.5),
                new ParallelGroup(
                        Intake.INSTANCE.stop,
                        Intake.INSTANCE.rotationconstop
                )

        );
    }
}

