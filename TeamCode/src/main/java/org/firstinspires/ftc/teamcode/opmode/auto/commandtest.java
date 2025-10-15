package org.firstinspires.ftc.teamcode.opmode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import dev.nextftc.ftc.NextFTCOpMode;
import org.firstinspires.ftc.teamcode.common.commands.shooting;

@Autonomous(name="Command Test", group = "Decode")
public class commandtest extends NextFTCOpMode {
    @Override
    public void onStartButtonPressed() {
        shooting yes = new shooting();
        yes.autoRoutine().schedule();
    }
}
