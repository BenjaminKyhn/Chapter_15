import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_20 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;
        final double RADIUS = 10;

        Circle a = new Circle(100, 400, RADIUS);
        Circle b = new Circle(200, 200, RADIUS);
        Circle c = new Circle(400, 400, RADIUS);

        Text tA = new Text("A");
        Text tB = new Text("B");
        Text tC = new Text("C");

        Line ab = new Line();
        Line bc = new Line();
        Line ca = new Line();

        EventHandler<MouseEvent> dragCircle = e -> {
            if (e.getButton().equals(MouseButton.PRIMARY)){
                Circle circle = (Circle)e.getSource();
                circle.setCenterX(e.getX());
                circle.setCenterY(e.getY());
                double angle = getAngle(bc, ca, ab);
                tA.setText(String.format("%.2f", angle));
                angle = getAngle(ca, bc, ab);
                tB.setText(String.format("%.2f", angle));
                angle = getAngle(ab, ca, bc);
                tC.setText(String.format("%.2f", angle));
            }
        };

        a.setOnMouseDragged(dragCircle);
        b.setOnMouseDragged(dragCircle);
        c.setOnMouseDragged(dragCircle);

        ab.startXProperty().bind(a.centerXProperty());
        ab.startYProperty().bind(a.centerYProperty());
        ab.endXProperty().bind(b.centerXProperty());
        ab.endYProperty().bind(b.centerYProperty());
        bc.startXProperty().bind(b.centerXProperty());
        bc.startYProperty().bind(b.centerYProperty());
        bc.endXProperty().bind(c.centerXProperty());
        bc.endYProperty().bind(c.centerYProperty());
        ca.startXProperty().bind(c.centerXProperty());
        ca.startYProperty().bind(c.centerYProperty());
        ca.endXProperty().bind(a.centerXProperty());
        ca.endYProperty().bind(a.centerYProperty());

        tA.xProperty().bind(a.centerXProperty());
        tA.yProperty().bind(a.centerYProperty().subtract(RADIUS));
        tB.xProperty().bind(b.centerXProperty());
        tB.yProperty().bind(b.centerYProperty().subtract(RADIUS));
        tC.xProperty().bind(c.centerXProperty());
        tC.yProperty().bind(c.centerYProperty().subtract(RADIUS));

        Pane pane = new Pane();
        pane.getChildren().addAll(ab, bc, ca, a, b, c, tA, tB, tC);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static double getAngle(Line x, Line y, Line z){
        double a = distance(x);
        double b = distance(y);
        double c = distance(z);
        return Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b *c)));
    }

    public static double distance(Line line){
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
