package org.firstinspires.ftc.teamcode.common.autocommands;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;

public class OuttakeCommand {
    public OuttakeCommand() {
        new SubsystemComponent(Pivot.INSTANCE, Flywheels.INSTANCE);
    }

    public Command autoRoutine() {
        return new SequentialGroup(
            Pivot.INSTANCE.reset,
            Flywheels.INSTANCE.on,
            new Delay(5),
            Flywheels.INSTANCE.off
        );
    }
}
