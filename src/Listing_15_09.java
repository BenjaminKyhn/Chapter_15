import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Listing_15_09 extends Application {
    private CirclePane circlePane = new CirclePane();

    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        btEnlarge.setOnAction(e -> circlePane.enlarge());
        btShrink.setOnAction(e -> circlePane.shrink());

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(circlePane);
        borderPane.setBottom(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        stage.setTitle("ControlCircle");
        stage.setScene(scene);
        stage.show();

        circlePane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.PRIMARY) {
                circlePane.enlarge();
            }
            if (e.getButton() == MouseButton.SECONDARY) {
                circlePane.shrink();
            }
        });

        /** The following DOES NOT WORK on my keyboard. For some reason the arrow keys are not registeret, but every
         * other key works fine. Also if the setOnKeyPressed is changed to setOnKeyReleased it will work with arrow
         * keys. Very strange.*/
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                circlePane.enlarge();
            }
            else if (e.getCode() == KeyCode.DOWN) {
                circlePane.shrink();
            }
        });
    }
}

