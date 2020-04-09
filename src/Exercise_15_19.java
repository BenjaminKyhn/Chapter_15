import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_19 extends Application {
    private static final double WIDTH = 500;
    private static final double HEIGHT = 500;
    private static final double RADIUS = 10;
    private static int count = 0;
    private static long startTime;
    private static long endTime;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        Circle circle = new Circle((Math.random() * (WIDTH - (RADIUS * 2))), (Math.random() * (HEIGHT - (RADIUS * 2))) + RADIUS, RADIUS);
        Text text = new Text(20, 30, "INSTRUCTION: \nClick 20 circles and get a time score");
        pane.getChildren().addAll(circle, text);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        circle.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                getCircle(pane, circle);
                startTime = System.currentTimeMillis();
            }
        });
    }

    public static void getCircle(Pane pane, Circle circle) {
        pane.getChildren().remove(circle);
        if (count < 19) {
            count++;
            Circle c = new Circle((Math.random() * (WIDTH - (RADIUS * 2))), (Math.random() * (HEIGHT - (RADIUS * 2))) + RADIUS, RADIUS);
            c.setOnMouseClicked(e -> {
                getCircle(pane, c);
            });
            pane.getChildren().add(c);
        } else {
            pane.getChildren().clear();
            endTime = System.currentTimeMillis();
            long time = endTime - startTime;
            Text text = new Text(WIDTH / 3, HEIGHT / 3, "Time spent is " + time / 1000 + " seconds");
            pane.getChildren().add(text);
        }
    }
}
