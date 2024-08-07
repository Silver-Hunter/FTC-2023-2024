package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Climbing TEST", group="Linear OpMode")

public class PulltheLeverKronk extends LinearOpMode {

    private DcMotor motor6 = null;
    private DcMotor motor7 = null;

    @Override
    public void runOpMode(){
        motor6 = hardwareMap.get(DcMotor.class, "motor6");
        motor7 = hardwareMap.get(DcMotor.class, "motor7");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {
            if (gamepad2.right_trigger > 0.000) {
                motor6.setPower(1.0);
                motor7.setPower(1.0);
            }
            else {
                motor6.setPower(0.0);
                motor7.setPower(0.0);
            }
            if (gamepad2.right_stick_x > 0.000) {
                motor6.setPower(-1.0);
                motor7.setPower(-1.0);
            }
            else {
                motor6.setPower(0.0);
                motor7.setPower(0.0);
            }

        }

    }


}
