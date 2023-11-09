package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

//@Disabled
@Autonomous
public class TrackWidthTuner extends LinearOpMode {

    DriveTrain driveTrain;
    TelemetryControl telemetryControl;

    // Change the trackWidth variable in DriveTrain until this opMode spins 90 degrees exactly.

    @Override
    public void runOpMode() {

        telemetryControl = new TelemetryControl(telemetry);
        driveTrain = new DriveTrain(hardwareMap, telemetryControl);

        waitForStart();

        driveTrain.EncoderAutoMecanumDrive(
                0,
                0,
                90,
                0.75,
                30
        );

    }

}
