import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;

public class Exercise_15_09 extends Application {
    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        final double WIDTH = 800;
        final double HEIGHT = 800;
        double[] position = {WIDTH / 2, HEIGHT / 2};

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(position[0], position[1]);
        polyline.setStroke(Color.BLACK);
        pane.getChildren().add(polyline);

        polyline.setOnKeyPressed(e ->{
            switch (e.getCode()){
                case UP: polyline.getPoints().addAll(position[0], position[1] -= 10); break;
                case DOWN: polyline.getPoints().addAll(position[0], position[1] += 10); break;
                case LEFT: polyline.getPoints().addAll(position[0] -= 10, position[1]); break;
                case RIGHT: polyline.getPoints().addAll(position[0] += 10, position[1]); break;
            }
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        polyline.requestFocus();
    }
}
