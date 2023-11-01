package org.firstinspires.ftc.teamcode.drive;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="And yet again", group="Linear OpMode")

public class armTest extends LinearOpMode {

    private DcMotor motor = null;
    public static final double MAX_FWD =  0.1;
    public static final double MAX_REV = -0.1;

    @Override
    public void runOpMode(){
        motor = hardwareMap.get(DcMotor.class, "armMotor");

        telemetry.addData("Status", "Initialized");
        telemetry.update();
        waitForStart();


        while (opModeIsActive()) {
            motor.setPower(0.1);
            motor.setPower(gamepad1.left_stick_x);

        }

    }


}
