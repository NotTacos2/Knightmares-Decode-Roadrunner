package org.firstinspires.ftc.teamcode.opmode.auto;

import com.pedropathing.paths.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.pedropathing.follower.Follower;
import com.pedropathing.geometry.Pose;
import com.pedropathing.geometry.BezierLine;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import org.firstinspires.ftc.teamcode.common.pedroPathing.Constants;
import org.firstinspires.ftc.teamcode.common.util.Robot;
import org.firstinspires.ftc.teamcode.common.util.Parts;

import org.firstinspires.ftc.teamcode.common.util.LimelightDetector;
import org.firstinspires.ftc.teamcode.common.util.Shooter;

@Autonomous(name = "67WSpeed", group = "Decode")
@Disabled // for now since we don't have a limelight
public class limelightAutoTest extends LinearOpMode {
    private Follower follower;
    private int motifartifact;
    private double horizontalangle;
    private double verticalangle;
    private LimelightDetector limelight;
    private PathChain scanning;
    public static final Pose startingpose = new Pose(56, 8, Math.toRadians(0));
    public static final Pose scanningpose = new Pose(55.22, 125.84, Math.toRadians(0));
    @Override
    public void runOpMode() throws InterruptedException {
        Parts config = new Parts(hardwareMap);
        Robot robot = new Robot();
        follower = Constants.createFollower(hardwareMap);
        follower.setStartingPose(startingpose);
        buildPaths(); // path builder for scanning
        limelight = new LimelightDetector();
        limelight.init(hardwareMap);


        follower.followPath(scanning);
        while (follower.isBusy()) {
            follower.update();
        }
        if (motifartifact == 0 && horizontalangle == 0 && verticalangle == 0){
            limelight.startScanning();
            motifartifact = limelight.aprilTagIDNumber();
            horizontalangle = limelight.goalHorizontalAngle();
            verticalangle = limelight.goalVerticalAngle();
        }
        if (motifartifact != 0 && horizontalangle != 0 && verticalangle != 0) {
            telemetry.addData("Motif ID#", motifartifact);
            telemetry.addData("Horizontal Goal Angle: ", horizontalangle);
            telemetry.addData("Vertical Goal Angle: ", verticalangle);
        }
        telemetry.update();

        if (motifartifact == 21) {
            telemetry.addData("So pattern is ", "Green Purple Purple");
            telemetry.update();
        }

        if (motifartifact == 22) {
            telemetry.addData("So pattern is ", "Purple Green Purple");
            telemetry.update();
        }

        if (motifartifact == 23) {
            telemetry.addData("So pattern is ", "Purple Purple Green");
            telemetry.update();
        }
        if (motifartifact == 20 || motifartifact == 24) {
            if (Math.abs(horizontalangle) > 1) {
                robot.moveleft();
            } else if (Math.abs(horizontalangle) < 1) {
                robot.moveright();
            } else if (Math.abs(verticalangle) > 1) {
                robot.moveback();
            } else if (Math.abs(verticalangle) < 1) {
                robot.movestraight();
            } else if (Math.abs(horizontalangle) == 1 || Math.abs(verticalangle) == 1) {
                robot.stopmoving();

                limelight.stopScanning();

                Shooter.shootauto();
            }
        }

    }


    public void buildPaths() {
        scanning = follower.pathBuilder()
                .addPath(new BezierLine(startingpose, scanningpose))
                .setConstantHeadingInterpolation(startingpose.getHeading())
                .build();
    }
}
