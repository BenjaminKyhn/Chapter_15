package Exercise_15_33;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exercise_15_33 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GBeanMachine bm = new GBeanMachine(10, 8);

        StackPane pane = new StackPane();
        pane.getChildren().add(bm);
        pane.setMargin(bm, new Insets(20));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
}
