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

@TeleOp(group="Decode")
public class oneplayer extends NextFTCOpMode {
    Parts part = new Parts();
    public oneplayer() {
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

        Gamepads.gamepad1().leftBumper().whenBecomesTrue(
                Pivot.INSTANCE.turn
        );
        Gamepads.gamepad1().rightBumper().whenBecomesTrue(
                Pivot.INSTANCE.reset
        );

        Gamepads.gamepad1().a()
                .whenBecomesTrue(Flywheels.INSTANCE.powerone.then(Flywheels.INSTANCE.powertwo))
                .whenBecomesFalse(Flywheels.INSTANCE.stopone.then(Flywheels.INSTANCE.stoptwo));

        Gamepads.gamepad1().b()
                .whenBecomesTrue(Flywheels.INSTANCE.negpowerone.then(Flywheels.INSTANCE.negpowertwo))
                .whenBecomesFalse(Flywheels.INSTANCE.stopone.then(Flywheels.INSTANCE.stoptwo));

        //Gamepads.gamepad1().x()
            //    .whenBecomesTrue(Intake.INSTANCE.power.then(Intake.INSTANCE.turn.then(Intake.INSTANCE.turn2)))
              //  .whenBecomesFalse(Intake.INSTANCE.stop.then(Intake.INSTANCE.reset.then(Intake.INSTANCE.reset2)));
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

