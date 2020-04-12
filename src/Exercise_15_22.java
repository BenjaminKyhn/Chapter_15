import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Exercise_15_22 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final double WIDTH = 500;
        final double HEIGHT = 500;
        final double X_RADIUS = WIDTH / 3;
        final double Y_RADIUS = WIDTH / 10;
        Pane pane = new Pane();

        Ellipse ellipse = new Ellipse(WIDTH / 2, HEIGHT / 5, X_RADIUS, Y_RADIUS);
        ellipse.centerXProperty().bind(pane.widthProperty().divide(2));
        ellipse.radiusXProperty().bind(pane.widthProperty().divide(3));
        ellipse.setFill(Color.WHITE);
        ellipse.setStroke(Color.BLACK);

        Arc arc1 = new Arc(WIDTH / 2, HEIGHT / 5 * 4, X_RADIUS, Y_RADIUS, 0, 180);
        arc1.centerXProperty().bind(pane.widthProperty().divide(2));
        arc1.radiusXProperty().bind(pane.widthProperty().divide(3));
        arc1.centerYProperty().bind(pane.heightProperty().divide(5).multiply(4));
        arc1.setFill(Color.TRANSPARENT);
        arc1.setStroke(Color.BLACK);
        arc1.setType(ArcType.OPEN);
        arc1.getStrokeDashArray().addAll(6.0, 21.0);

        Arc arc2 = new Arc(WIDTH / 2, HEIGHT / 5 * 4, X_RADIUS, Y_RADIUS, 180, 180);
        arc2.centerXProperty().bind(pane.widthProperty().divide(2));
        arc2.radiusXProperty().bind(pane.widthProperty().divide(3));
        arc2.centerYProperty().bind(pane.heightProperty().divide(5).multiply(4));
        arc2.setFill(Color.TRANSPARENT);
        arc2.setStroke(Color.BLACK);
        arc2.setType(ArcType.OPEN);

        Line line1 = new Line();
        line1.startXProperty().bind(ellipse.centerXProperty().subtract(ellipse.radiusXProperty()));
        line1.startYProperty().bind(ellipse.centerYProperty());
        line1.endXProperty().bind(arc1.centerXProperty().subtract(ellipse.radiusXProperty()));
        line1.endYProperty().bind(arc1.centerYProperty());

        Line line2 = new Line();
        line2.startXProperty().bind(ellipse.centerXProperty().add(ellipse.radiusXProperty()));
        line2.startYProperty().bind(ellipse.centerYProperty());
        line2.endXProperty().bind(arc1.centerXProperty().add(arc1.radiusXProperty()));
        line2.endYProperty().bind(arc1.centerYProperty());

        pane.getChildren().addAll(ellipse, arc1, arc2, line1, line2);

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();
    }
}
