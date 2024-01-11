package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Take it, Kronk, feel the power", group="Linear OpMode")

public class PulltheLeverKronk extends LinearOpMode {

    private DcMotor motor6 = null;
    private DcMotor motor7 = null;

    @Override
    public void runOpMode(){
        motor6 = hardwareMap.get(DcMotor.class, "armMotor");
        motor7 = hardwareMap.get(DcMotor.class, "armMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {
            motor6.setPower(1.0);
            motor7.setPower(1.0);
            motor6.setPower(gamepad2.right_trigger);
            motor7.setPower(gamepad2.right_trigger);

        }

    }


}
