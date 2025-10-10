package org.firstinspires.ftc.teamcode.common;

import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.impl.IMUEx;

public class Parts {

    // declaring parts
    public static MotorEx FR, FL, BR, BL;
    public static MotorEx flywheel1, flywheel2;
    public static ServoEx pivot;
    public static IMUEx imu;

    public Parts() {
        FL = new MotorEx("leftFront").reversed().brakeMode();
        FR = new MotorEx("rightFront").brakeMode();
        BR = new MotorEx("rightRear").brakeMode();
        BL = new MotorEx("leftRear").reversed().brakeMode();

        flywheel1 = new MotorEx("shooterOne").reversed().brakeMode();
        flywheel2 = new MotorEx("shooterTwo").brakeMode();

        pivot = new ServoEx("pivotServo");

        imu = new IMUEx("imu", Direction.UP, Direction.RIGHT).zeroed();
    }
}