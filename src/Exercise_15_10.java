import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_10 extends Application {
    @Override
    public void start(Stage stage) {
        StackPane stackPane = new StackPane();
        StringBuilder sb = new StringBuilder();

        stackPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                stackPane.getChildren().clear();
                Text text = new Text(sb.toString());
                stackPane.getChildren().add(text);
                sb.delete(0, sb.length());
            } else
                sb.append(e.getText());
        });

        Scene scene = new Scene(stackPane, 200, 100);
        stage.setScene(scene);
        stage.show();

        stackPane.requestFocus();
    }
}
