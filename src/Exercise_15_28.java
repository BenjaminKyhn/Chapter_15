import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Exercise_15_28 extends Application {
    boolean isSpinningLeft = true;

    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;
        final double CENTER_X = WIDTH / 2;
        final double CENTER_Y = HEIGHT / 2;
        final double RADIUS = 200;
        Pane fanPane = new Pane();
        HBox controlPane = new HBox();
        BorderPane pane = new BorderPane();
        Arc[] blades = new Arc[6];

        pane.setCenter(fanPane);
        pane.setBottom(controlPane);

        Circle fanCircle = new Circle(CENTER_X, CENTER_Y, RADIUS);
        fanCircle.setFill(Color.TRANSPARENT);
        fanCircle.setStroke(Color.BLACK);

        for (int i = 0, sa = 0; i < 6; i++, sa += 60) {
            Arc arc = new Arc(CENTER_X, CENTER_Y, RADIUS - 10, RADIUS - 10, sa, 30);
            arc.setType(ArcType.ROUND);
            blades[i] = arc;
            if (i % 2 == 0){
                arc.setOpacity(0.75);
            }
            fanPane.getChildren().add(arc);
        }

        fanPane.getChildren().addAll(fanCircle);

        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");

        controlPane.getChildren().addAll(btPause, btResume, btReverse);

        EventHandler<ActionEvent> spinFan = e ->{
            int increment = isSpinningLeft ? 1 : -1;
            for (int i = 0; i < blades.length; i++) {
                double prevStartAngle = blades[i].getStartAngle();
                blades[i].setStartAngle(prevStartAngle + increment);
            }
        };

        KeyFrame kf = new KeyFrame(Duration.millis(5), spinFan);

        Timeline t1 = new Timeline(kf);
        t1.setCycleCount(Timeline.INDEFINITE);
        t1.play();

        btPause.setOnAction(e -> t1.pause());
        btResume.setOnAction(e -> t1.play());
        btReverse.setOnAction(e -> isSpinningLeft = !isSpinningLeft);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
