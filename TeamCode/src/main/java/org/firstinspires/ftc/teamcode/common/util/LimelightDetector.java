package org.firstinspires.ftc.teamcode.common.util;

import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.LLResultTypes;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LimelightDetector {
    private Limelight3A limelight;
    public void init(HardwareMap hardwareMap) { // TODO: move this to parts
        limelight = hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);
    }

    public void startScanning() {
        limelight.start();
    }

    public int aprilTagIDNumber() {
        LLResult llresult = limelight.getLatestResult();
        if (llresult != null && llresult.isValid()) {
            for (LLResultTypes.FiducialResult AprilTag : llresult.getFiducialResults()) {
                if (AprilTag.getFiducialId() == 20) {
                    return 20;
                }
                else if (AprilTag.getFiducialId() == 21) { // 1:1 fr
                    return 21;
                }
                else if (AprilTag.getFiducialId() == 22) {
                    return 22;
                }
                else if (AprilTag.getFiducialId() == 23) {
                    return 23;
                }
                else if (AprilTag.getFiducialId() == 24) {
                    return 24;
                }
            }
        }
        return 0;
    }

    public double goalHorizontalAngle(){
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            return result.getTx();
        }
        return 0;
    }

    public double goalVerticalAngle(){
        LLResult result = limelight.getLatestResult();

        if (result != null && result.isValid()) {
            return result.getTy();
        }
        return 0;
    }

    public void stopScanning() {
        limelight.stop();
    }
}
