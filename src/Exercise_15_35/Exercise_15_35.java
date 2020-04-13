package Exercise_15_35;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Time;
import java.util.ArrayList;

public class Exercise_15_35 extends Application {
    static int currentIndex = 0;
    static ArrayList<Point2D> points = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        int size = 16;
        LatticePane latticePane = new LatticePane(size, 20);
        SelfAvoidingWalk walk = new SelfAvoidingWalk(size);

        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);

        Button btStart = new Button("Start");
        btStart.setOnAction(e -> {
            startPathAnimation(latticePane, walk);
        });

        controlPane.getChildren().add(btStart);

        BorderPane pane = new BorderPane();
        pane.setCenter(latticePane);
        pane.setBottom(controlPane);
        pane.setMargin(latticePane, new Insets(20));
        pane.setMargin(controlPane, new Insets(0, 0, 20, 0));

        startPathAnimation(latticePane, walk);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void startPathAnimation(LatticePane latticePane, SelfAvoidingWalk walk){
        currentIndex = 0;
        walk.walk();
        points = walk.getPath();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), e ->{
            if (currentIndex == points.size()){
                currentIndex = 0;
            }
            latticePane.nextStep(currentIndex, points);
            currentIndex++;
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
