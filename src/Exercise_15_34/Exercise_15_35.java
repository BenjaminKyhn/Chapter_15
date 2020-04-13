package Exercise_15_34;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_15_35 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        LatticePane latticePane = new LatticePane(16, 20);
        SelfAvoidingWalk walk = new SelfAvoidingWalk(16);
        walk.walk();
        latticePane.drawWalk(walk);

        HBox controlPane = new HBox();
        controlPane.setAlignment(Pos.CENTER);

        Button btStart = new Button("Start");
        btStart.setOnAction(e -> {
            latticePane.resetGrid();
            walk.walk();
            latticePane.drawWalk(walk);
        });

        controlPane.getChildren().add(btStart);

        BorderPane pane = new BorderPane();
        pane.setCenter(latticePane);
        pane.setBottom(controlPane);
        pane.setMargin(latticePane, new Insets(20));
        pane.setMargin(controlPane, new Insets(0, 0, 20, 0));

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
