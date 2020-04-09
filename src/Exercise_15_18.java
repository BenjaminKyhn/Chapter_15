import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_15_18 extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        Rectangle rectangle = new Rectangle(200, 200, 150, 150);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);

        pane.getChildren().add(rectangle);

        rectangle.setOnMouseDragged(e -> {
            ((Rectangle) e.getSource()).setX(e.getX() - (rectangle.getHeight() / 2));
            ((Rectangle) e.getSource()).setY(e.getY() - (rectangle.getWidth() / 2));
        });

        Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}
