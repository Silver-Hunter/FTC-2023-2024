package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="And yet again", group="Linear OpMode")

public class armTest extends LinearOpMode {

    private DcMotor motor5 = null;

    @Override
    public void runOpMode(){
        motor5 = hardwareMap.get(DcMotor.class, "armMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {
            motor5.setPower(0.1);
            motor5.setPower(gamepad1.left_stick_x);

        }

    }


}
