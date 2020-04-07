import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Listing_15_15 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane = new StackPane();
        Text text = new Text(20, 50, "Programming is fun");
        text.setFill(Color.RED);
        pane.getChildren().add(text); // Place text into the stack pane

        // Create a handler for changing text
        EventHandler<ActionEvent> eventEventHandler = e -> {
            if (text.getText().length() != 0){
                text.setText("");
            }
            else {
                text.setText("Programming is fun");
            }
        };

        // Create an animation for alternating text
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(500), eventEventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        // Pause and resume animation
        text.setOnMouseClicked(e -> {
            if (animation.getStatus() == Animation.Status.PAUSED){
                animation.play();
            }
            else {
                animation.pause();
            }
        });

        Scene scene = new Scene(pane, 250, 250);
        stage.setTitle("TimelineDemo");
        stage.setScene(scene);
        stage.show();
    }
}
