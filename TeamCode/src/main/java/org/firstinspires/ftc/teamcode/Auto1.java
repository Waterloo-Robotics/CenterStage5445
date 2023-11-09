package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class Auto1 extends LinearOpMode {

    DriveTrain driveTrain;
    TelemetryControl telemetryControl;

    @Override
    public void runOpMode() {

        telemetryControl = new TelemetryControl(telemetry);
        driveTrain = new DriveTrain(hardwareMap, telemetryControl);

        waitForStart();

        driveTrain.EncoderAutoMecanumDrive(
                40,
                0,
                0,
                0.75,
                30
        );

    }

}
