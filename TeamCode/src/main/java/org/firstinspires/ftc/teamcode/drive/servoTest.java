package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class servoTest extends LinearOpMode {
    private Servo servo1;
    @Override
    public void runOpMode() {
        if (gamepad2.a){
            servo1.setPosition(0);
        }
        if (gamepad2.b){
            servo1.setPosition(1);
        }

    }
}
