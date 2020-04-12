import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_29 extends Application {
    static int currentXCoord = 0;

    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;

        Pane pane = new Pane();

        KeyFrame keyFrame = new KeyFrame(Duration.millis(10), e -> drawCar(currentXCoord, HEIGHT, pane));
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        pane.setOnMouseClicked(e -> {
            if (timeline.getStatus().equals(Animation.Status.RUNNING)) {
                timeline.pause();
            } else {
                timeline.play();
            }
        });

        pane.setOnKeyPressed(e -> {
            switch (e.getCode()){
                case UP: timeline.setRate(timeline.getRate() + 1); break;
                case DOWN: timeline.setRate(timeline.getRate() - 1);
            }
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        pane.requestFocus();
    }

    public static void drawCar(double x, double y, Pane pane) {
        pane.getChildren().clear();
        if (currentXCoord > 500) {
            currentXCoord = 0;
        }
        Rectangle body = new Rectangle(x, y - 20, 50, 10);
        body.setFill(Color.DEEPSKYBLUE);
        Circle leftTire = new Circle(x + 10, y - 5, 5);
        Circle rightTire = new Circle(x + 35, y - 5, 5);
        Polygon top = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        top.setFill(Color.DODGERBLUE);
        pane.getChildren().addAll(body, leftTire, rightTire, top);
        currentXCoord++;
    }
}
