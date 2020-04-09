import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise_15_17 extends Application {
    @Override
    public void start(Stage stage) {
        final double WIDTH = 500;
        final double HEIGHT = 500;
        final double RADIUS = 10;
        ArrayList<Double> xPoints = new ArrayList<>();
        ArrayList<Double> yPoints = new ArrayList<>();

        Text text = new Text(20, 30, "INSTRUCTION\nAdd: Left Click\nRemove: Right Click");

        Pane pane = new Pane();
        pane.getChildren().add(text);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        EventHandler<MouseEvent> removePoint = e -> {
            if (e.getButton().equals(MouseButton.SECONDARY)){
                Circle c = (Circle)e.getSource();
                xPoints.remove(c.getCenterX());
                yPoints.remove(c.getCenterY());
                pane.getChildren().remove(e.getSource());
                removeRect(pane.getChildren());
                if (xPoints.size() > 0 && yPoints.size() > 0){
                    Rectangle r = getRect(xPoints, yPoints, RADIUS);
                    pane.getChildren().add(r);
                    r.toBack();
                }
            }
        };

        EventHandler<MouseEvent> addPoint = e-> {
            if (e.getButton().equals(MouseButton.PRIMARY)){
                xPoints.add(e.getX());
                Collections.sort(xPoints);
                yPoints.add(e.getY());
                Collections.sort(yPoints);
                Rectangle r = getRect(xPoints, yPoints, RADIUS);
                Circle c = new Circle(e.getX(), e.getY(), RADIUS);
                c.setFill(Color.WHITE);
                c.setStroke(Color.BLACK);
                c.setOnMouseClicked(removePoint);
                removeRect(pane.getChildren());
                pane.getChildren().addAll(c, r);
                r.toBack();
            }
        };

        pane.setOnMouseClicked(addPoint);
    }

    public static Rectangle getRect(ArrayList<Double> xPoints, ArrayList<Double> yPoints, double radius){
        double minX = xPoints.get(0) - radius;
        double minY = yPoints.get(0) - radius;
        double maxX = xPoints.get(xPoints.size() - 1) + radius;
        double maxY = yPoints.get(yPoints.size() -1) + radius;
        Rectangle r = new Rectangle(minX, minY, maxX - minX, maxY - minY);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(Color.BLACK);
        return r;
    }

    public static void removeRect(ObservableList<Node> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Rectangle){
                list.remove(i);
                break;
            }
        }
    }
}
