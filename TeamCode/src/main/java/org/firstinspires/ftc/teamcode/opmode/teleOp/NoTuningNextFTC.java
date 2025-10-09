//package org.firstinspires.ftc.teamcode.opmode.teleOp;

/*import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.core.commands.Command;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.hardware.driving.FieldCentric;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.ftc.Gamepads;

import org.firstinspires.ftc.teamcode.common.util.Parts;
import org.firstinspires.ftc.teamcode.common.util.Shooter;
@TeleOp(name = "NextFTC but no tune", group = "Decode")
public class NoTuningNextFTC extends NextFTCOpMode {
    public Command driverControlled;

    @Override
    public void onStartButtonPressed() {
        driverControlled = new MecanumDriverControlled(
                Parts.FL.getDeviceName(),
                Parts.FR.getDeviceName(),
                Parts.BL.getDeviceName(),
                Parts.BR.getDeviceName(),
                Gamepads.gamepad1().leftStickY(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX(),
                new FieldCentric()
        );
        driverControlled.schedule();

        Shooter.shootmanual(gamepad1.a);
    }
}
*/