package org.firstinspires.ftc.teamcode.common.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.localization.Encoder;
import com.pedropathing.ftc.localization.constants.DriveEncoderConstants;
import com.pedropathing.ftc.localization.localizers.DriveEncoderLocalizer;
import com.pedropathing.ftc.localization.localizers.ThreeWheelIMULocalizer;
import com.pedropathing.localization.Localizer;
import com.pedropathing.paths.PathConstraints;
import com.pedropathing.ftc.drivetrains.MecanumConstants;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.common.util.Parts;


public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants()
            .mass(7.257);
            //.robotLength(8.5)
            //.robotWidth(13.5)

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static DriveEncoderConstants localizerConstants = new DriveEncoderConstants()
            // this is jacob's config so um yeah!!
            .leftFrontMotorName("leftFront")
            .leftRearMotorName("leftRear")
            .rightFrontMotorName("rightFront")
            .rightRearMotorName("rightRear")
            .leftFrontEncoderDirection(Encoder.REVERSE)
            .leftRearEncoderDirection(Encoder.REVERSE);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .driveEncoderLocalizer(localizerConstants)
                .build();
    }
}
