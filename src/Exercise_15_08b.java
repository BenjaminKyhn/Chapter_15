import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_08b extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        pane.setOnMousePressed(e -> {
            Text text = new Text();
            double x = e.getX();
            double y = e.getY();
            text.setText("(" + x + "," + y + ")");
            text.setX(x);
            text.setY(y);
            pane.getChildren().add(text);
        });

        pane.setOnMouseDragged(e -> {
            pane.getChildren().clear();
            double x = e.getX();
            double y = e.getY();
            Text position = new Text("(" + x + ", " + y + ")");
            position.setX(x);
            position.setY(y);
            pane.getChildren().add(position);
        });

        pane.setOnMouseReleased(e -> {
            pane.getChildren().clear();
        });

        Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}
