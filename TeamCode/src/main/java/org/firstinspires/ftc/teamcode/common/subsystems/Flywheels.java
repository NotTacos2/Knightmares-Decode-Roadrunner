package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.powerable.SetPower;

public class Flywheels implements Subsystem {
    public static final Flywheels INSTANCE = new Flywheels();
    private Flywheels() {}

    private MotorEx motorone = new MotorEx("shooterOne").reversed().brakeMode();
    private MotorEx motortwo = new MotorEx("shooterTwo").brakeMode();

    // idk names for these
    public Command powerone = new SetPower(motorone, 1).requires(this);
    public Command powertwo = new SetPower(motortwo, 1).requires(this);
    public Command negpowerone = new SetPower(motorone, -1).requires(this);
    public Command negpowertwo = new SetPower(motortwo, -1).requires(this);
    public Command stopone = new SetPower(motorone, 0).requires(this);
    public Command stoptwo = new SetPower(motortwo, 0).requires(this);
}