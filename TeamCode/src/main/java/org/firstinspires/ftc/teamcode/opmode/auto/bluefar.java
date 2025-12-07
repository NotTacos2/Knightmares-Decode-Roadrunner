package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.common.Parts;


@Autonomous (name = "Blue Far", group = "Decode")
public class bluefar extends LinearOpMode {
    public void runOpMode() throws InterruptedException {
        Parts config = new Parts(); // configure robot
        waitForStart();

        Parts.FL.setPower(0.5);
        Parts.FR.setPower(0.5);
        Parts.BL.setPower(0.5);
        Parts.BR.setPower(0.5);
        sleep(400);
        Parts.FL.setPower(0);
        Parts.FR.setPower(0);
        Parts.BL.setPower(0);
        Parts.BR.setPower(0);


        Parts.flywheel1.setPower(0.82);
        Parts.flywheel2.setPower(0.82);
        sleep(2500);
        Parts.intake.setPower(1);
        Parts.intake2.setPower(-1);
        sleep(500);
        Parts.intake.setPower(0);
        Parts.intake2.setPower(0);
        sleep(2050);
        Parts.intake.setPower(1);
        Parts.intake2.setPower(-1);
        sleep(500);
        Parts.intake.setPower(0);
        Parts.intake2.setPower(0);
        sleep(2000);
        Parts.intake.setPower(1);
        Parts.intake2.setPower(-1);
        sleep(2000);
        Parts.flywheel1.setPower(0);
        Parts.flywheel2.setPower(0);
        Parts.intake.setPower(0);
        Parts.intake2.setPower(0);
        sleep(1000);

        Parts.FL.setPower(0.5);
        Parts.FR.setPower(-0.5);
        Parts.BL.setPower(0.5);
        Parts.BR.setPower(0.5);
        sleep(500);
        Parts.FL.setPower(0.5);
        Parts.FR.setPower(0.5);
        Parts.BL.setPower(0.5);
        Parts.BR.setPower(0.5);
        sleep(500);
        Parts.FL.setPower(0);
        Parts.FR.setPower(0);
        Parts.BL.setPower(0);
        Parts.BR.setPower(0);
    }


}