import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Collections;

public class Exercise_15_01 extends Application {
    private ArrayList<Integer> cards;
    private HBox hBox = new HBox();

    @Override
    public void start(Stage stage) {
        // Adjust the HBox
        hBox.setPadding(new Insets(10));
        hBox.setSpacing(10);

        // Create a button and give it an on-action event
        Button btRefresh = new Button("Refresh");
        btRefresh.setOnAction(e -> {
            getFourRandomCards(cards);
        });

        // Create a border pane and add the elements to the pane
        BorderPane pane = new BorderPane();
        pane.setCenter(hBox);
        pane.setBottom(btRefresh);
        pane.setAlignment(btRefresh, Pos.CENTER);

        // Add cards to the list and display 4 random ones
        cards = getCards();
        getFourRandomCards(cards);

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    // Add integers to the ArrayList
    private ArrayList<Integer> getCards() {
        ArrayList<Integer> c = new ArrayList<>();
        for (int i = 1; i <= 54; i++) {
            c.add(i);
        }
        shuffle(c);
        return c;
    }

    // Given an ArrayList of integers, add the images from the /image/ folder corresponding to the first 4 integers to the HBox
    // The ArrayList is shuffled each time to produce 4 random images
    private void getFourRandomCards(ArrayList<Integer> cards){
        hBox.getChildren().clear();
        shuffle(cards);
        for (int i = 0; i < 4; i++) {
            ImageView imageView = new ImageView("image/" + cards.get(i) + ".png");
            hBox.getChildren().add(imageView);
        }
    }

    // Shuffle an ArrayList of integers
    private void shuffle(ArrayList<Integer> cards){
        Collections.shuffle(cards);
    }
}
