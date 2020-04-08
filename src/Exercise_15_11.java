import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Exercise_15_11 extends Application {
    final double WIDTH = 500;
    final double HEIGHT = 500;

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane(); // Does not work with StackPane
        Circle circle = new Circle(WIDTH / 2, HEIGHT / 2, 50);
        pane.getChildren().add(circle);

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        pane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP || e.getCode() == KeyCode.W)
                circle.setCenterY(circle.getCenterY() > 0 + circle.getRadius() ? circle.getCenterY() - 5 : 0 + circle.getRadius());

            if (e.getCode() == KeyCode.DOWN || e.getCode() == KeyCode.S)
                circle.setCenterY(circle.getCenterY() < pane.getHeight() - circle.getRadius() ? circle.getCenterY() + 5 : pane.getHeight() - circle.getRadius());

            if (e.getCode() == KeyCode.LEFT || e.getCode() == KeyCode.A)
                circle.setCenterX(circle.getCenterX() > 0 + circle.getRadius() ? circle.getCenterX() - 5 : 0 + circle.getRadius());

            if (e.getCode() == KeyCode.RIGHT || e.getCode() == KeyCode.D)
                circle.setCenterX(circle.getCenterX() < pane.getWidth() - circle.getRadius() ? circle.getCenterX() + 5 : pane.getWidth() - circle.getRadius());
        });

        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        stage.setTitle("Move Circle");
        stage.setScene(scene);
        stage.show();

        pane.requestFocus();
    }
}
