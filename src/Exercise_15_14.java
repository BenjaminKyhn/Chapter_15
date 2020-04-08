import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_14 extends Application {
    @Override
    public void start(Stage stage) {
        Polygon polyline = new Polygon(30, 10, 60, 30, 50, 70, 35, 35, 10, 50);
        polyline.setStroke(Color.BLACK);
        polyline.setFill(Color.WHITE);
        Pane pane = new Pane(polyline);
        Text text = new Text("Mouse point is outside the polygon");

        pane.setOnMouseMoved(e -> {
            pane.getChildren().remove(text);
            double x = e.getX();
            double y = e.getY();
            text.setX(x);
            text.setY(y);
            if (polyline.contains(x, y))
                text.setText("Mouse point is inside the polygon");
            else
                text.setText("Mouse point is outside the polygon");
            pane.getChildren().add(text);
        });

        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
