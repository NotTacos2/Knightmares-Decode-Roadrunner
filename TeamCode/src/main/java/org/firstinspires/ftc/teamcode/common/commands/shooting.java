package org.firstinspires.ftc.teamcode.common.commands;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.commands.delays.Delay;
import dev.nextftc.core.commands.groups.SequentialGroup;
import dev.nextftc.core.commands.groups.ParallelGroup;
import dev.nextftc.core.components.SubsystemComponent;

import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;

public class shooting { // ok so tyler, this is basically shooting command for auto
    public shooting() { // initalizes shooting by calling flywheels and pivot commands
        new SubsystemComponent(Pivot.INSTANCE, Flywheels.INSTANCE);
    }

    public Command autoRoutine() {
        return new SequentialGroup( // these are commands and sequentialgroup runs them one by one
            Pivot.INSTANCE.reset, // calls the reset command so shooting works
            new ParallelGroup( // parallelgroup runs them all
                Flywheels.INSTANCE.powerone, // powers the flywheel which is one motor
                Flywheels.INSTANCE.powertwo // powers the other flywheel
            ),
            new Delay(0.5), // delays by 500 ms and we'll see how the balls go
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

