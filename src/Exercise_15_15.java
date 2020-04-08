import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Exercise_15_15 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();

        pane.setOnMouseClicked(e -> {
            double x = e.getX();
            double y = e.getY();
            if (e.getButton() == MouseButton.PRIMARY) {
                Circle circle = new Circle(x, y, 5);
//                circle.setOnMouseClicked(f ->{
//                    pane.getChildren().remove(f.getSource());
//                });
                pane.getChildren().add(circle);
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                for (Node child : pane.getChildren()) {
                    if (child.contains(x, y)){
                        pane.getChildren().remove(child);
                    }
                }
            }
        });

        Scene scene = new Scene(pane, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
