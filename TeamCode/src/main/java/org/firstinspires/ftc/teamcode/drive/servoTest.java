package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "servoTest (N/A)")
public class servoTest extends LinearOpMode {
    private Servo servo1;
    @Override
    public void runOpMode() {
        servo1 = hardwareMap.get(Servo.class, "pinch");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();

        while (opModeIsActive()) {
            if (gamepad2.x){
                servo1.setPosition(0);
            }
            if (gamepad2.y){
                servo1.setPosition(1);
            }
        }


    }
}
