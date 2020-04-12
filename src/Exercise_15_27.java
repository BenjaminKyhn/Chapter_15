import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_27 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;

        Pane pane = new Pane();
        Text text = new Text(WIDTH / 2, HEIGHT / 2, "Welcome to Java");

        Line line = new Line(-50, HEIGHT / 2, WIDTH + 50, HEIGHT / 2);

        pane.getChildren().add(text);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(line);
        pt.setNode(text);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
