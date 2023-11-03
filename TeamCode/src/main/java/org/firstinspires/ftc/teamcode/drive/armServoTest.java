package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class armServoTest extends LinearOpMode {
    private Servo servo3;
    @Override
    public void runOpMode() {
        servo3 = hardwareMap.get(Servo.class, "creeeak");

        if (gamepad2.a){
            servo3.setPosition(0);
        }
        if (gamepad2.b){
            servo3.setPosition(1);
        }

    }
}
