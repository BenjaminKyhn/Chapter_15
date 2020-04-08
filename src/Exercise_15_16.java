import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_16 extends Application {
    private double radius = 10;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();

        Circle circle1 = new Circle(40, 40, radius);
        circle1.setFill(Color.WHITE);
        circle1.setStroke(Color.BLACK);
        Circle circle2 = new Circle(120, 150, radius);
        circle2.setFill(Color.WHITE);
        circle2.setStroke(Color.BLACK);
        Line line = new Line(circle1.getCenterX(), circle1.getCenterY(), circle2.getCenterX(), circle2.getCenterY());
        line.startXProperty().bind(circle1.centerXProperty());
        line.startYProperty().bind(circle1.centerYProperty());
        line.endXProperty().bind(circle2.centerXProperty());
        line.endYProperty().bind(circle2.centerYProperty());
        Text text = new Text(getMidX(line), getMidY(line), String.valueOf(distance(line)));

        pane.getChildren().addAll(line, circle1, circle2, text);

        // Make an event handler because we'll be using the same event 2 times
        EventHandler<MouseEvent> dragCircle = e ->{
            ((Circle)e.getSource()).setCenterX(e.getX());
            ((Circle)e.getSource()).setCenterY(e.getY());
            text.setX(getMidX(line));
            text.setY(getMidY(line));
            text.setText(String.valueOf(distance(line)));
        };

        circle1.setOnMouseDragged(dragCircle);
        circle2.setOnMouseDragged(dragCircle);

        Scene scene = new Scene(pane, 300, 300);
        stage.setScene(scene);
        stage.show();
    }

    public static double distance(Line line){
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static double getMidX(Line line){
        return (line.getStartX() + line.getEndX()) / 2;
    }

    public static double getMidY(Line line){
        return (line.getStartY() + line.getEndY()) / 2;
    }
}
