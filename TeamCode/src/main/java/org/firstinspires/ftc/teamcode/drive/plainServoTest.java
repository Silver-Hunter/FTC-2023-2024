package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class plainServoTest extends LinearOpMode {
    private Servo servo2;
    @Override
    public void runOpMode() {
        servo2 = hardwareMap.get(Servo.class, "weeeee");

        if (gamepad2.dpad_up){
            servo2.setPosition(1.0);
        }

    }
}
