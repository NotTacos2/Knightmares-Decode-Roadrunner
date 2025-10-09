package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.positionable.SetPosition;

public class Pivot implements Subsystem {
    public static final Pivot INSTANCE = new Pivot();
    private Pivot() {}

    private ServoEx servo = new ServoEx("pivotServo");

    // idk names for these
    public Command turn = new SetPosition(servo, -0.2).requires(this);
    public Command otherthan = new SetPosition(servo, 0.015).requires(this);
}
