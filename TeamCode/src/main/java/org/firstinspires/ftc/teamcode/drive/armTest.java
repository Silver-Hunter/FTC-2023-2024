package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="errrmm, acually (N/A)", group="Linear OpMode")

public class armTest extends LinearOpMode {

    private DcMotor motor8 = null;

    @Override
    public void runOpMode(){
        motor8 = hardwareMap.get(DcMotor.class, "armMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();
        while (opModeIsActive()) {
            motor8.setPower(0.01);
            motor8.setPower(-gamepad2.left_stick_y);

        }

    }


}
