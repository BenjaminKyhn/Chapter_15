import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_13 extends Application {
    @Override
    public void start(Stage stage) {
        Rectangle rectangle = new Rectangle(80, 50, 100, 30);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
        Pane pane = new Pane(rectangle);
        Text text = new Text("Mouse point is outside the rectangle");

        pane.setOnMouseMoved(e -> {
            pane.getChildren().remove(text);
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (rectangle.contains(x, y))
                text.setText("Mouse point is inside the rectangle");
            else
                text.setText("Mouse point is outside the rectangle");
            pane.getChildren().add(text);
        });

        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
