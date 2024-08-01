package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servo TEST 2")
public class pleaseworkidontwanttobeupallnight extends LinearOpMode {
    private Servo servo2;

    @Override
    public void runOpMode() {
        servo2 = hardwareMap.get(Servo.class, "weeeee");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad2.dpad_up) {
                servo2.setPosition(0);
            }
            if (gamepad2.dpad_down) {
                servo2.setPosition(1);
            }
        }
    }
}
