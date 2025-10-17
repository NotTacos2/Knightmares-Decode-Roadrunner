// This is our flywheels subsystem which is a group of commands

package org.firstinspires.ftc.teamcode.common.subsystems;

import dev.nextftc.core.commands.Command;
import dev.nextftc.core.subsystems.Subsystem;
import dev.nextftc.hardware.powerable.SetPower;
import org.firstinspires.ftc.teamcode.common.Parts;

public class Flywheels implements Subsystem {
    public static final Flywheels INSTANCE = new Flywheels(); // makes this as group of commands
    private Flywheels() {}

    Parts part = new Parts();


    // idk names for these
    public Command powerone = new SetPower(Parts.flywheel1, 1).requires(this); // powers this by 1 which is full speed and you can't go more otherwise it will be counted as one
    public Command powertwo = new SetPower(Parts.flywheel2, 1).requires(this);
    public Command negpowerone = new SetPower(Parts.flywheel1, -1).requires(this); // powers this by -1 which is reverse full speed and like I said you can't go less otherwise counted as -1
    public Command negpowertwo = new SetPower(Parts.flywheel2, -1).requires(this);
    public Command stopone = new SetPower(Parts.flywheel1, 0).requires(this); // stops giving power to motor
    public Command stoptwo = new SetPower(Parts.flywheel2, 0).requires(this);

}
