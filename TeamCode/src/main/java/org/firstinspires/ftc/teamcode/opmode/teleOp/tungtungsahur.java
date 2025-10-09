package org.firstinspires.ftc.teamcode.opmode.teleOp;

import dev.nextftc.core.commands.Command;
import dev.nextftc.ftc.NextFTCOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import dev.nextftc.hardware.driving.FieldCentric;
import dev.nextftc.hardware.driving.MecanumDriverControlled;
import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.IMUEx;
import dev.nextftc.ftc.Gamepads;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.core.components.BindingsComponent;
import dev.nextftc.ftc.components.BulkReadComponent;
import org.firstinspires.ftc.teamcode.common.subsystems.Pivot;
import org.firstinspires.ftc.teamcode.common.subsystems.Flywheels;

@TeleOp(name = "Tung TUng Tung sahur low taper face", group="Decode")
public class tungtungsahur extends NextFTCOpMode {
    public tungtungsahur() {
        addComponents(
                BulkReadComponent.INSTANCE,
                BindingsComponent.INSTANCE
        );
    }

    private final MotorEx frontLeft = new MotorEx("leftFront").reversed().brakeMode();
    private final MotorEx frontRight = new MotorEx("rightFront").brakeMode();
    private final MotorEx backLeft = new MotorEx("leftRear").reversed().brakeMode();
    private final MotorEx backRight = new MotorEx("rightRear").brakeMode();
    private IMUEx imu = new IMUEx("imu", Direction.UP, Direction.RIGHT).zeroed();

    @Override
    public void onStartButtonPressed() {
         Command driverControlled = new MecanumDriverControlled(
                 frontLeft,
                 frontRight,
                 backLeft,
                 backRight,
                 Gamepads.gamepad1().leftStickY().negate(),
                 Gamepads.gamepad1().leftStickX(),
                 Gamepads.gamepad1().rightStickX(),
                 new FieldCentric(imu)
         );
        driverControlled.schedule();

        Gamepads.gamepad1().leftBumper().whenBecomesTrue(
                Pivot.INSTANCE.turn
        );
        Gamepads.gamepad1().rightBumper().whenBecomesTrue(
                Pivot.INSTANCE.otherthan
        );

        Gamepads.gamepad1().a()
                .whenBecomesTrue(Flywheels.INSTANCE.powerone.then(Flywheels.INSTANCE.powertwo))
                .whenBecomesFalse(Flywheels.INSTANCE.stopone.then(Flywheels.INSTANCE.stoptwo));

        Gamepads.gamepad1().b()
                .whenBecomesTrue(Flywheels.INSTANCE.negpowerone.then(Flywheels.INSTANCE.negpowertwo))
                .whenBecomesFalse(Flywheels.INSTANCE.stopone.then(Flywheels.INSTANCE.stoptwo));
    }
}
