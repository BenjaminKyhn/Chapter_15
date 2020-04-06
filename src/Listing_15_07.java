import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Listing_15_07 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        // Create a pane and set its properties
        Pane pane = new Pane();
        Text text = new Text(20, 20, "Programming is fun");
        pane.getChildren().addAll(text);
        text.setOnMouseDragged(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 300, 100);
        stage.setTitle("MouseEventDemo");
        stage.setScene(scene);
        stage.show();
    }
}
