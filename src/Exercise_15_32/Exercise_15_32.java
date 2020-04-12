package Exercise_15_32;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_15_32 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ClockPane clock = new ClockPane();
        clock.setWidth(500);
        clock.setHeight(500);

        Button btStart = new Button("Start");
        Button btStop = new Button("Stop");
        btStart.setOnAction(e -> clock.start());
        btStop.setOnAction(e -> clock.stop());

        HBox hBox = new HBox(btStart, btStop);
        hBox.setAlignment(Pos.CENTER);

        BorderPane pane = new BorderPane();
        pane.setCenter(clock);
        pane.setBottom(hBox);
        pane.setPadding(new Insets(10));

        clock.start();

        Scene scene = new Scene (pane);
        stage.setScene(scene);
        stage.show();
    }
}
