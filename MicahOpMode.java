package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.TouchSensor;


@TeleOp(name = "MainOpMode")
public class MicahOpMode extends LinearOpMode {

    private CRServo Left;
    private CRServo Right;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor LaunchMotor;
    private TouchSensor Touch;

    @Override
    public void runOpMode(){
        double Speed;
        double Turn_Speed;
        double Vertical;
        double Horizontal;
        double Pivot;

        Left = hardwareMap.get(CRServo.class, "Left");
        Right = hardwareMap.get(CRServo.class, "Right");
        frontLeft = hardwareMap.get(DcMotor.class, "front Left");
        frontRight = hardwareMap.get(DcMotor.class, "front Right");
        backLeft = hardwareMap.get(DcMotor.class, "back Left");
        backRight = hardwareMap.get(DcMotor.class, "back Right");
        LaunchMotor = hardwareMap.get(DcMotor.class, "Launch Motor");
        Touch = hardwareMap.get(TouchSensor.class, "Touch");

        backRight.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        Speed = 0.5;
        Turn_Speed = 0.55;

        waitForStart();
        if (opModeIsActive()) {

            Vertical = Math.min(Math.max(gamepad1.right_stick_x, -Speed), Speed);
            Horizontal = Math.min(Math.max(-gamepad1.left_stick_y, -Speed), Speed);
            Pivot = Math.min(Math.max(gamepad1.left_stick_x, -Turn_Speed), Turn_Speed);
            backLeft.setPower(-Pivot + (Vertical - Horizontal));
            backRight.setPower(-Pivot + Vertical + Horizontal);
            frontLeft.setPower(Pivot + Vertical + Horizontal);
            frontRight.setPower(Pivot + (Vertical - Horizontal));

        }

    }

}
