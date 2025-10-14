package org.firstinspires.ftc.teamcode.opmode.teleOp;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import dev.nextftc.ftc.NextFTCOpMode;
import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;

@TeleOp(name= "Limelight Scanning Test", group="Decode")
public class limelightTest extends NextFTCOpMode {
    private Limelight3A limelight;
    @Override
    public void onInit() {
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);
    }

    @Override
    public void onStartButtonPressed() {
        limelight.start();
    }

    @Override
    public void onUpdate() {
        LLResult result = limelight.getLatestResult();
        if (result != null && result.isValid()) {
            for (LLResultTypes.FiducialResult apriltag : result.getFiducialResults()) {
                telemetry.addData("April tag is ", apriltag.getFiducialId());
                telemetry.update();
            }
        } else if (result == null) {
            telemetry.addData("uhhh idk????", "wtf is that anyways");
            telemetry.update();
        }
    }
}
