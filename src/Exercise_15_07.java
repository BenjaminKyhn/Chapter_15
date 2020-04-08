import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_07 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane = new StackPane();
        Circle circle = new Circle(50);
        stackPane.getChildren().add(circle);

        circle.setFill(Color.BLUE);

        circle.setOnMousePressed(e -> circle.setFill(Color.RED));
        circle.setOnMouseReleased(e -> circle.setFill(Color.BLUE));

        Scene scene = new Scene(stackPane, 200, 200);
        stage.setScene(scene);
        stage.show();
    }
}
