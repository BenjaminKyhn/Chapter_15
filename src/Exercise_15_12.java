import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_12 extends Application {
    @Override
    public void start(Stage stage) {
        Circle circle = new Circle(100, 60, 50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        Pane pane = new Pane(circle);
        Text text = new Text("Mouse point is outside the circle");

        pane.setOnMouseMoved(e -> {
            pane.getChildren().remove(text);
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (circle.contains(x, y))
                text.setText("Mouse point is inside the circle");
            else
                text.setText("Mouse point is outside the circle");
            pane.getChildren().add(text);
        });

        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
