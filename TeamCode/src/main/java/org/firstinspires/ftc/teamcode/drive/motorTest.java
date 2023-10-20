package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name = "testy", group = "Linear OpMode")
public class motorTest extends LinearOpMode {
    private DcMotor motor1 = null;
    private DcMotor motor2 = null;

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        motor1 = hardwareMap.get(DcMotor.class, "motor1");
        motor2 = hardwareMap.get(DcMotor.class, "motor2");

        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {
            motor1.setDirection(DcMotor.Direction.REVERSE);
            motor2.setDirection(DcMotor.Direction.FORWARD);
            telemetry.addData("Status", "Running");
            telemetry.update();
        }
        while (opModeIsActive()) {
            double leftPower;
            double rightPower;
            double drive = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;
            leftPower = Range.clip(drive + turn, -1.0,1.0);
            rightPower = Range.clip(drive - turn, -1.0, 1.0);
            motor1.setPower(leftPower);
            motor2.setPower(rightPower);
        }
    }
}

