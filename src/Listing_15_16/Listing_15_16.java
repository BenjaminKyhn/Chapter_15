package Listing_15_16;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Listing_15_16 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClockPane clock = new ClockPane(); // Create a clock

        // Create a handler for animation
        EventHandler<ActionEvent> eventEventHandler = e -> {
            clock.setCurrentTime(); // Set a new clock time
        };

        // Create an animation for a running clock
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000), eventEventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start the animation

        Scene scene = new Scene(clock, 250, 50);
        stage.setTitle("ClockAnimation");
        stage.setScene(scene);
        stage.show();
    }
}
