import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_24 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create a pane
        Pane pane = new Pane();

        // Create an arc
        Arc arc = new Arc(150, 150, 100, 50,200, 140);
        arc.setFill(Color.TRANSPARENT);
        arc.setStroke(Color.BLACK);
        arc.setType(ArcType.OPEN);

        // Create a circle
        Circle circle = new Circle(arc.getCenterX() - arc.getRadiusX(), arc.getCenterY(), 10);
        circle.setFill(Color.BLACK);

        // Add circle and rectangle to the pane
        pane.getChildren().addAll(arc, circle);

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(2000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        pane.setOnMousePressed(e -> pt.pause());
        pane.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
