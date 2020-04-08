import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Exercise_15_05b extends Application {
    private TextField tfInitialVelocity = new TextField();
    private TextField tfAcceleration = new TextField();
    private TextField tfTime = new TextField();
    private TextField tfFinalVelocityMeterPerSecond = new TextField();
    private TextField tfFinalVelocityKilometerPerHour = new TextField();
    private Button btCalculate = new Button("Calculate");

    @Override
    public void start(Stage stage) {
        // Create UI
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Initial Velocity (m/s):"), 0, 0);
        gridPane.add(tfInitialVelocity, 1, 0);
        gridPane.add(new Label("Acceleration (m/s2):"), 0, 1);
        gridPane.add(tfAcceleration, 1, 1);
        gridPane.add(new Label("Time (s)"), 0, 2);
        gridPane.add(tfTime, 1, 2);
        gridPane.add(new Label("Final velocity (m/s):"), 0, 3);
        gridPane.add(tfFinalVelocityMeterPerSecond, 1, 3);
        gridPane.add(new Label("Final velocity (km/h):"), 0, 4);
        gridPane.add(tfFinalVelocityKilometerPerHour, 1, 4);
        gridPane.add(btCalculate, 1, 5);

        // Set properties for UI
        gridPane.setAlignment(Pos.CENTER);
        tfInitialVelocity.setAlignment(Pos.BOTTOM_RIGHT);
        tfAcceleration.setAlignment(Pos.BOTTOM_RIGHT);
        tfTime.setAlignment(Pos.BOTTOM_RIGHT);
        tfFinalVelocityMeterPerSecond.setAlignment(Pos.BOTTOM_RIGHT);
        tfFinalVelocityMeterPerSecond.setEditable(false);
        tfFinalVelocityKilometerPerHour.setAlignment(Pos.BOTTOM_RIGHT);
        tfFinalVelocityKilometerPerHour.setEditable(false);
        GridPane.setHalignment(btCalculate, HPos.RIGHT);

        // Process events
        btCalculate.setOnAction(e -> calculateFinalVelocity());

        // Create a scene and place it in the stage
        Scene scene = new Scene(gridPane, 300, 200);
        stage.setTitle("Velocity Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void calculateFinalVelocity() {
        // Get values from text fields
        double initialVelocity = Double.parseDouble(tfInitialVelocity.getText());
        double acceleration = Double.parseDouble(tfAcceleration.getText());
        double time = Double.parseDouble(tfTime.getText());

        double finalVelocityMeterPerSecond = initialVelocity + (acceleration * time);
        double finalVelocityKilometersPerHour = finalVelocityMeterPerSecond / 1000 * 3600;

        // Display monthly payment and total payment
        tfFinalVelocityMeterPerSecond.setText(String.format("%.2f m/s", finalVelocityMeterPerSecond));
        tfFinalVelocityKilometerPerHour.setText(String.format("%.2f km/h", finalVelocityKilometersPerHour));
    }
}
