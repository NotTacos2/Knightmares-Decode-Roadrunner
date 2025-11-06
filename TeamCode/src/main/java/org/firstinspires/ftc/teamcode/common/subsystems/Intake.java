package org.firstinspires.ftc.teamcode.common.subsystems;

import android.provider.Telephony;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.powerable.SetPower;
import dev.nextftc.hardware.positionable.SetPosition;
import org.firstinspires.ftc.teamcode.common.Parts;

public class Intake implements Subsystem {
    public static final Intake INSTANCE = new Intake();
    private Intake() {}

    Parts part = new Parts();

    public Command power = new SetPower(Parts.intake, 1).requires(this);
    public Command reverse = new SetPower(Parts.intake, -1).requires(this);
    public Command stop = new SetPower(Parts.intake, 0).requires(this);
    public Command rotationcon = new SetPower(Parts.intake2, -1);
    public Command rotationconreverse = new SetPower(Parts.intake2, 1);
    public Command rotationconstop = new SetPower(Parts.intake2, 0);
    //public Command reset = new SetPosition(Parts.intakeservo, 0.5).requires(this);
    //public Command turn = new SetPosition(Parts.intakeservo, 1).requires(this);
    //public Command reset2 = new SetPosition(Parts.intakeservo2, 0.5).requires(this);
    //public Command turn2 = new SetPosition(Parts.intakeservo2, 1).requires(this);

}

