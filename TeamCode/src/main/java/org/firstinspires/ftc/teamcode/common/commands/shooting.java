package org.firstinspires.ftc.teamcode.common.commands;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;

public class shooting {
    public shooting() {
        new SubsystemComponent(Pivot.INSTANCE, Flywheels.INSTANCE);
    }

    public Command autoRoutine() {
        return new SequentialGroup(
            Pivot.INSTANCE.reset,
            new ParallelGroup(
                Flywheels.INSTANCE.powerone,
                Flywheels.INSTANCE.powertwo
            ),
            new Delay(0.5),
            new ParallelGroup(
                 Flywheels.INSTANCE.stopone,
                 Flywheels.INSTANCE.stoptwo
            ),
            new Delay(0.5),
            new ParallelGroup(
                 Flywheels.INSTANCE.powerone,
                 Flywheels.INSTANCE.powertwo
            ),
            new Delay(0.5),
            new ParallelGroup(
                 Flywheels.INSTANCE.stopone,
                 Flywheels.INSTANCE.stoptwo
            ),
            new Delay(0.5),
            new ParallelGroup(
                 Flywheels.INSTANCE.powerone,
                 Flywheels.INSTANCE.powertwo
            ),
            new Delay(0.5),
            new ParallelGroup(
                 Flywheels.INSTANCE.stopone,
                 Flywheels.INSTANCE.stoptwo
            )
        );
    }
}
