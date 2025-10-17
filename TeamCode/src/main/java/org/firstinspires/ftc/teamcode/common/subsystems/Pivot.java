package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.positionable.SetPosition;
import org.firstinspires.ftc.teamcode.common.Parts;

public class Pivot implements Subsystem {
    public static final Pivot INSTANCE = new Pivot();
    private Pivot() {}

    Parts part = new Parts();

    // idk names for these
    public Command turn = new SetPosition(Parts.pivot, -0.2).requires(this);
    public Command reset = new SetPosition(Parts.pivot, 0.015).requires(this);
}
