import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class Listing_15_18 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BallPane ballPane = new BallPane(); // Create a ball pane

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Increase and decrease animation
        ballPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP){
                ballPane.increaseSpeed();
            }
            else if (e.getCode() == KeyCode.DOWN){
                ballPane.decreaseSpeed();
            }
        });

        Scene scene = new Scene(ballPane, 250, 150);
        stage.setTitle("BounceBallControl");
        stage.setScene(scene);
        stage.show();

        // Must request focus after the primary stage is displayed
        ballPane.requestFocus();
    }
}
