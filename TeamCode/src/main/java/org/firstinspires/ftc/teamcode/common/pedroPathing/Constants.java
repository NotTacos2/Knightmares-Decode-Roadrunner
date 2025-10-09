package org.firstinspires.ftc.teamcode.common.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.localization.constants.ThreeWheelIMUConstants;
import com.pedropathing.paths.PathConstraints;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.common.util.Parts;


public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(7.257);

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static ThreeWheelIMUConstants localizerConstants = new ThreeWheelIMUConstants()
            .forwardTicksToInches(67)
            .strafeTicksToInches(67)
            .turnTicksToInches(67)
            .leftEncoder_HardwareMapName(Parts.FL.getDeviceName())
            .rightEncoder_HardwareMapName(Parts.BR.getDeviceName())
            .strafeEncoder_HardwareMapName(Parts.FR.getDeviceName())
            .IMU_HardwareMapName(Parts.imu.getDeviceName())
            .IMU_Orientation(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP, RevHubOrientationOnRobot.UsbFacingDirection.LEFT));


    public static MecanumConstants driveConstants = new MecanumConstants()
            // this is jacob's config so um yeah!!
            .leftFrontMotorName(Parts.FL.getDeviceName())
            .leftRearMotorName(Parts.BL.getDeviceName())
            .rightFrontMotorName(Parts.FR.getDeviceName())
            .rightRearMotorName(Parts.BR.getDeviceName())
            .leftFrontMotorDirection(DcMotorSimple.Direction.REVERSE)
            .leftRearMotorDirection(DcMotorSimple.Direction.REVERSE);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .mecanumDrivetrain(driveConstants)
                .threeWheelIMULocalizer(localizerConstants)
                .build();
    }
}
