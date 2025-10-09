package org.firstinspires.ftc.teamcode.opmode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.extensions.pedro.PedroDriverControlled;
import dev.nextftc.core.commands.Command;
import dev.nextftc.ftc.NextFTCOpMode;
import dev.nextftc.extensions.pedro.PedroComponent;
import dev.nextftc.ftc.Gamepads;

import org.firstinspires.ftc.teamcode.common.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.common.util.Shooter;
@TeleOp(name = "TeleOP V2 Test", group = "Decode")
public class NextFTCTeleOP extends NextFTCOpMode {
    public NextFTCTeleOP() {
        addComponents(
                new PedroComponent(Constants::createFollower)
        );
    }

    @Override
    public void onStartButtonPressed() {
        Command fieldcentric = new PedroDriverControlled(
                Gamepads.gamepad1().leftStickY(),
                Gamepads.gamepad1().leftStickX(),
                Gamepads.gamepad1().rightStickX(),
                false
        );
        fieldcentric.schedule();

        Shooter.shootmanual(gamepad1.a);
    }
}
