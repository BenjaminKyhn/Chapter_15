import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Listing_15_11 extends Application {
    // Create a circle and a rectangle
    private Circle circle = new Circle(60);
    private Rectangle rectangle = new Rectangle(120, 120);

    // Place a clock and label in border pane
    private StackPane pane = new StackPane();

    @Override
    public void start(Stage stage) throws Exception {
        circle.setFill(Color.GRAY);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        pane.getChildren().addAll(rectangle, circle);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 140, 140);
        stage.setTitle("ResizableRectangleCircke");
        stage.setScene(scene);
        stage.show();

        pane.widthProperty().addListener(ov -> resize());
        pane.heightProperty().addListener(ov -> resize());
    }

    private void resize() {
        double length = Math.min(pane.getWidth(), pane.getHeight());
        circle.setRadius(length / 2 - 15);
        rectangle.setWidth(length - 30);
        rectangle.setHeight(length - 30);
    }
}
