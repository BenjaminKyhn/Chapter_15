import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_15_15 extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        pane.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(x, y, 10);
                circle.setOnMouseClicked(f ->{
                    pane.getChildren().remove(f.getSource());
                });
                pane.getChildren().add(circle);
            }
        });

        Scene scene = new Scene(pane, 500, 500);
        stage.setScene(scene);
        stage.show();
    }
}
