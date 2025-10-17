package org.firstinspires.ftc.teamcode.common;

import dev.nextftc.hardware.impl.Direction;
import dev.nextftc.hardware.impl.MotorEx;
import dev.nextftc.hardware.impl.ServoEx;
import dev.nextftc.hardware.impl.IMUEx;

public class Parts { // this is our parts code, which contains our parts name (motors and servos) set from driver station

    // declaring parts
    public static MotorEx FR, FL, BR, BL;
    public static MotorEx flywheel1, flywheel2;
    public static ServoEx pivot;
    public static IMUEx imu;

    public Parts() {
        FL = new MotorEx("leftFront").reversed().brakeMode(); // so basically this is our wheels and lefts needs to be reversed otherwise our driving is hard
        FR = new MotorEx("rightFront").brakeMode(); // we need add brake mode to all of our motors because they stop instantly once it's setpower is 0
        BR = new MotorEx("rightRear").brakeMode();
        BL = new MotorEx("leftRear").reversed().brakeMode();

        flywheel1 = new MotorEx("shooterOne").reversed().brakeMode();
        flywheel2 = new MotorEx("shooterTwo").brakeMode();

        pivot = new ServoEx("pivotServo"); // our servo, doesn't need to be reversed or braked

        imu = new IMUEx("imu", Direction.UP, Direction.RIGHT).zeroed(); // this is our imu, which is our control hub and logo direction is up and usb direction is right, zeroed makes it reset (I think?)
    }
}
