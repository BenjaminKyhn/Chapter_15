import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_31 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;
        final double CENTER_X = WIDTH / 2;
        final double CENTER_Y = HEIGHT / 3;

        // Create a pane
        Pane pane = new Pane();

        // Create a hook and a ball
        Circle ball = new Circle(10);
        ball.setFill(Color.BLACK);
        Circle hook = new Circle(CENTER_X, CENTER_Y, 5);
        hook.setFill(Color.BLACK);

        // Create a chain to connect them
        Line chain = new Line();
        chain.startXProperty().bind(hook.centerXProperty());
        chain.startYProperty().bind(hook.centerYProperty());
        chain.endXProperty().bind(ball.translateXProperty());
        chain.endYProperty().bind(ball.translateYProperty());

        // Create an arc
        Arc path = new Arc(CENTER_X, HEIGHT / 5 * 3, WIDTH / 5 * 2, HEIGHT / 5, 200, 140);
        path.setFill(Color.TRANSPARENT);
        path.setStroke(Color.BLACK);
        path.setType(ArcType.OPEN);

        // Add them all to the pane
        pane.getChildren().addAll(path, ball, chain);

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(2000));
        pt.setPath(path);
        pt.setNode(ball);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
