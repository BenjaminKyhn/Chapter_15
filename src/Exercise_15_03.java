import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exercise_15_03 extends Application {
    private RectanglePane rectanglePane = new RectanglePane();

    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");
        Button btUp = new Button("Up");
        Button btDown = new Button("Down");
        hBox.getChildren().addAll(btLeft, btRight, btUp, btDown);

        btLeft.setOnAction(e -> rectanglePane.left());
        btRight.setOnAction(e -> rectanglePane.right());
        btUp.setOnAction(e -> rectanglePane.up());
        btDown.setOnAction(e -> rectanglePane.down());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(rectanglePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 250, 250);
        stage.setTitle("Move Rectangle");
        stage.setScene(scene);
        stage.show();
    }
}

class RectanglePane extends StackPane{
    private Rectangle rectangle = new Rectangle(50, 50);

    public RectanglePane(){
        getChildren().add(rectangle);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
    }

    public void left(){
        rectangle.setTranslateX(rectangle.getTranslateX() - 5);
    }

    public void right(){
        rectangle.setTranslateX(rectangle.getTranslateX() + 5);
    }

    public void up(){
        rectangle.setTranslateY(rectangle.getTranslateY() - 5);
    }

    public void down(){
        rectangle.setTranslateY(rectangle.getTranslateY() + 5);
    }
}