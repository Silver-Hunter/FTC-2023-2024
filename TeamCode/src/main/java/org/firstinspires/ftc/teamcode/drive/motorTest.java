package org.firstinspires.ftc.teamcode.drive;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

/*
 * 1) Axial:    Driving forward and backward               Left-joystick Forward/Backward
 * 2) Lateral:  Strafing right and left                     Left-joystick Right and Left
 * 3) Yaw:      Rotating Clockwise and counter clockwise    Right-joystick Right and Left
 */

@TeleOp(name="Starting over, as usual", group="Linear OpMode")

public class motorTest extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotor motor5 = null;
    private DcMotor motor6;
    private DcMotor motor7 = null;
    private DcMotor motor8;
    private Servo servo1;
    private Servo servo2;

    @Override
    public void runOpMode() {

        // Initialize the hardware variables. Note that the strings used here must correspond
        // to the names assigned during the robot configuration step on the DS or RC devices.
        frontLeft = hardwareMap.get(DcMotor.class, "motor1");
        frontRight = hardwareMap.get(DcMotor.class, "motor2");
        backLeft = hardwareMap.get(DcMotor.class, "motor3");
        backRight = hardwareMap.get(DcMotor.class, "motor4");
        motor8 = hardwareMap.get(DcMotor.class, "motor8");
        motor6 = hardwareMap.get(DcMotor.class, "motor6");
        motor7 = hardwareMap.get(DcMotor.class, "motor7");
        motor5 = hardwareMap.get(DcMotor.class, "motor5");
        servo1 = hardwareMap.get(Servo.class, "creeeak");
//        servo2 = hardwareMap.get(Servo.class, "pinch");

        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);



        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);

        // Wait for the game to start (driver presses PLAY)
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            motor8.setPower(0.1);
            motor8.setPower(Math.pow(gamepad2.left_stick_x, 3));

            double max;

            double axial   = -gamepad1.left_stick_y;  // Note: pushing stick forward gives negative value
            double lateral =  gamepad1.left_stick_x;
            double yaw     =  gamepad1.right_stick_x;

            if (gamepad1.left_trigger > 0.000) {
                axial = axial * 0.55;
                lateral = lateral * 0.55;
                yaw = yaw * 0.55;
            }
            if (gamepad1.left_trigger > 0.000 && gamepad1.left_trigger < 0.001) {
                axial = axial / 0.55;
                lateral = lateral / 0.55;
                yaw = yaw / 0.55;
            }
                // Combine the joystick requests for each axis-motion to determine each wheel's power.
            // Set up a variable for each drive wheel to save the power level for telemetry.
            double leftFrontPower  = axial + lateral + yaw;
            double rightFrontPower = axial - lateral - yaw;
            double leftBackPower   = axial - lateral + yaw;
            double rightBackPower  = axial + lateral - yaw;

            // Normalize the values so no wheel power exceeds 100%
            // This ensures that the robot maintains the desired motion.
            max = Math.max(Math.abs(leftFrontPower), Math.abs(rightFrontPower));
            max = Math.max(max, Math.abs(leftBackPower));
            max = Math.max(max, Math.abs(rightBackPower));

            if (max > 1.0) {
                leftFrontPower  /= max;
                rightFrontPower /= max;
                leftBackPower   /= max;
                rightBackPower  /= max;
            }

            frontLeft.setPower(Math.pow(leftFrontPower, 3));
            frontRight.setPower(Math.pow(rightFrontPower, 3));
            backLeft.setPower(Math.pow(leftBackPower, 3));
            backRight.setPower(Math.pow(rightBackPower, 3));

            int position1 = frontLeft.getCurrentPosition();
            int position2 = frontRight.getCurrentPosition();
            int position3 = backLeft.getCurrentPosition();
            int position4 = backRight.getCurrentPosition();

            if (gamepad2.x){
                servo1.setPosition(0);
            }
            if (gamepad2.y){
                servo1.setPosition(1);
            }

//            if (gamepad2.a) {
//                servo2.setPosition(0);
//            }
//            if (gamepad2.b) {

//                servo2.setPosition(1);
//            }
            motor5.setPower(-gamepad2.left_trigger);

//            if (gamepad2.right_trigger > 0.000) {
//                motor6.setPower(1.0);
//                motor7.setPower(1.0);
//            }
//            if (gamepad2.right_trigger > 0.000 && gamepad2.left_trigger < 0.001) {
//                motor6.setPower(0.0);
//                motor7.setPower(0.0);
//            }
//            if (gamepad2.right_stick_x > 0.000) {
//                motor6.setPower(-1.0);
//                motor7.setPower(-1.0);
//            }
//            if (gamepad2.right_stick_x > 0.000 && gamepad2.right_stick_x < 0.001) {
//                motor6.setPower(0.0);
//                motor7.setPower(0.0);
//            }

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.addData("Front left/Right", "%4.2f, %4.2f", leftFrontPower, rightFrontPower);
            telemetry.addData("Back  left/Right", "%4.2f, %4.2f", leftBackPower, rightBackPower);
            telemetry.addData("Encoder 1 Position", position1);
            telemetry.addData("Encoder 2 Position", position2);
            telemetry.addData("Encoder 3 position", position3);
            telemetry.addData("Encoder 4 position", position4);
            telemetry.update();
        }
    }
}