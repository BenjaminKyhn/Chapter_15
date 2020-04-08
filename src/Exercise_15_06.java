import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercise_15_06 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane = new StackPane();
        Text text = new Text("Programming is fun");
        stackPane.getChildren().add(text);

        text.setOnMouseClicked(e ->{
            if (text.getText().equals("Programming is fun"))
                text.setText("Welcome to Java");
            else
                text.setText("Programming is fun");
        });

        Scene scene = new Scene(stackPane, 200, 100);
        stage.setScene(scene);
        stage.show();
    }
}
