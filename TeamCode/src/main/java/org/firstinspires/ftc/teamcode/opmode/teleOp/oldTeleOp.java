package org.firstinspires.ftc.teamcode.opmode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.common.util.Parts;
import org.firstinspires.ftc.teamcode.common.util.Robot;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.teamcode.common.util.Shooter;

@TeleOp(name = "No Tuning Tele OP")
public class oldTeleOp extends LinearOpMode {
    private Servo servo;
    @Override
    public void runOpMode() {
        Parts config = new Parts(hardwareMap);
        Robot robot = new Robot();

        waitForStart();

        servo = hardwareMap.get(Servo.class, "pivotServo");
        while (opModeIsActive()) {
            robot.feildCentric(gamepad1);
            if (gamepad1.left_bumper) {
                servo.setPosition(-0.2);
            } else if (gamepad1.right_bumper) {
                servo.setPosition(0.015);
            }
            Shooter.shootmanual(gamepad1.a);
            //Shooter.sixseven(gamepad1.b);
        }
    }
}
