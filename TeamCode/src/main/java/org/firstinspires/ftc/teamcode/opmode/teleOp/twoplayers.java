package org.firstinspires.ftc.teamcode.opmode.teleOp;

import dev.nextftc.bindings.BindingManager;
import dev.nextftc.core.commands.Command;
import dev.nextftc.ftc.NextFTCOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.hardware.driving.FieldCentric;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.ftc.components.BulkReadComponent;
import dev.nextftc.core.components.SubsystemComponent;
import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;
import org.firstinspires.ftc.teamcode.common.subsystems.Intake;
import org.firstinspires.ftc.teamcode.common.Parts;

@TeleOp(group = "Decode")
public class twoplayers extends NextFTCOpMode {
    Parts part = new Parts();
    public twoplayers() {
        addComponents(
                new SubsystemComponent(Pivot.INSTANCE, Flywheels.INSTANCE, Intake.INSTANCE),
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    @Override
    public void onStartButtonPressed() {
         Command driverControlled = new MecanumDriverControlled(
                 Parts.FL,
                 Parts.FR,
                 Parts.BL,
                 Parts.BR,
                 Gamepads.gamepad1().leftStickY().negate(),
                 Gamepads.gamepad1().leftStickX(),
                 Gamepads.gamepad1().rightStickX(),
                 new FieldCentric(Parts.imu)
         );
        driverControlled.schedule();

        Gamepads.gamepad2().leftBumper().whenBecomesTrue(
                Pivot.INSTANCE.turn
        );
        Gamepads.gamepad2().rightBumper().whenBecomesTrue(
                Pivot.INSTANCE.reset
        );

        Gamepads.gamepad2().a()
                .whenBecomesTrue(Flywheels.INSTANCE.on)
                .whenBecomesFalse(Flywheels.INSTANCE.off);

        Gamepads.gamepad2().b()
                .whenBecomesTrue(Flywheels.INSTANCE.reverse)
                .whenBecomesFalse(Flywheels.INSTANCE.off);

        Gamepads.gamepad2().leftTrigger().greaterThan(0.2)
                .whenBecomesTrue(Intake.INSTANCE.power)
                .whenBecomesFalse(Intake.INSTANCE.stop);

        Gamepads.gamepad2().x()
                .whenBecomesTrue(Intake.INSTANCE.rotationcon)
                .whenBecomesFalse(Intake.INSTANCE.rotationconstop);

    }

    @Override
    public void onUpdate() {
        BindingManager.update();
    }

    @Override
    public void onStop() {
        BindingManager.reset();
    }
}
