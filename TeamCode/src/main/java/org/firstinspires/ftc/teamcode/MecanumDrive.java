package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "Mecanum TeleOp", group = "!")
public class MecanumDrive extends OpMode {

    TelemetryControl telemetryControl;
    DriveTrain driveTrain;

    Servo droneServo;

    boolean isAPressed = false;
    boolean isAPressedOnce = false;
    ElapsedTime time;

    @Override
    public void init() {

        telemetryControl = new TelemetryControl(telemetry);
        driveTrain = new DriveTrain(hardwareMap, telemetryControl);

        driveTrain.setDriveTrainType(DriveTrain.DriveTrainType.MECANUM);

        droneServo = hardwareMap.servo.get("droneServo");

    }

    @Override
    public void loop() {

        driveTrain.MecanumTeleOp(
                gamepad1.left_stick_y,
                gamepad1.left_stick_x,
                gamepad1.right_stick_x
        );

        if (gamepad2.a) {

            if (!isAPressed) {

                if (!isAPressedOnce) {

                    time.reset();
                    isAPressedOnce = true;

                } else if (isAPressedOnce && time.seconds() < 0.5) {

                    droneServo.setPosition(0.42);
                    isAPressedOnce = false;

                }

            }

            isAPressed = true;

        } else {

            isAPressed = false;

        }

    }

}
