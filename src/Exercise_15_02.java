import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class Exercise_15_02 extends Application {
    private EllipsePane ellipsePane= new EllipsePane();

    @Override
    public void start(Stage stage) {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btRotate = new Button("Rotate");
        hBox.getChildren().add(btRotate);

        btRotate.setOnAction(e -> ellipsePane.rotate());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(ellipsePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 250, 250);
        stage.setTitle("Rorate Ellipse");
        stage.setScene(scene);
        stage.show();
    }
}

class EllipsePane extends StackPane{
    private Ellipse ellipse = new Ellipse(50, 100);

    public EllipsePane(){
        getChildren().add(ellipse);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
    }

    public void rotate(){
        ellipse.setRotate(ellipse.getRotate() + 5);
    }
}