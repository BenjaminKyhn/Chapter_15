import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_26 extends Application {
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
        PathTransition pt = new PathTransition(Duration.millis(2000), arc, circle);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        FadeTransition ft = new FadeTransition(Duration.millis(1000), circle);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        pane.setOnMousePressed(e -> {
            pt.pause();
            ft.pause();
        });
        pane.setOnMouseReleased(e -> {
            pt.play();
            ft.play();
        });

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }
}
