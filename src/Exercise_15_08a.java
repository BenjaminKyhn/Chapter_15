import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_08a extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        pane.setOnMouseClicked(e -> {
            pane.getChildren().clear();
            Text text = new Text();
            double x = e.getX();
            double y = e.getY();
            text.setText("(" + x + "," + y + ")");
            text.setX(x);
            text.setY(y);
            pane.getChildren().add(text);
        });

        Scene scene = new Scene(pane, 800, 800);
        stage.setScene(scene);
        stage.show();
    }
}
