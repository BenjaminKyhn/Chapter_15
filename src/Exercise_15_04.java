import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exercise_15_04 extends Application {
    private Label labelN1 = new Label("Number 1:");
    private Label labelN2 = new Label("Number 2:");
    private Label labelResult = new Label("Result:");
    private TextField tfN1 = new TextField();
    private TextField tfN2 = new TextField();
    private TextField tfResult = new TextField();
    private Button btAdd = new Button("Add");
    private Button btSubtract = new Button("Subtract");
    private Button btMultiply = new Button("Multiply");
    private Button btDivide = new Button("Divide");

    @Override
    public void start(Stage stage) {
        /** Should have used a GridPane instead as it would have looked nicer */
        HBox hBox1 = new HBox();
        HBox hBox2 = new HBox();
        VBox vBox = new VBox();

        hBox1.getChildren().addAll(labelN1, tfN1, labelN2, tfN2, labelResult, tfResult);
        hBox2.getChildren().addAll(btAdd, btSubtract, btMultiply, btDivide);
        vBox.getChildren().addAll(hBox1, hBox2);

        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
        tfN1.setMaxWidth(50);
        tfN2.setMaxWidth(50);
        tfResult.setMaxWidth(50);
        tfResult.setEditable(false);

        btAdd.setOnAction(e -> add());
        btSubtract.setOnAction(e -> subtract());
        btMultiply.setOnAction(e -> multiply());
        btDivide.setOnAction(e -> divide());

        Scene scene = new Scene(vBox, 300, 200);
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void add() {
        double n1 = Double.parseDouble(tfN1.getText());
        double n2 = Double.parseDouble(tfN2.getText());

        double result = n1 + n2;

        tfResult.setText(String.format("%.2f", result));
    }

    private void subtract() {
        double n1 = Double.parseDouble(tfN1.getText());
        double n2 = Double.parseDouble(tfN2.getText());

        double result = n1 - n2;

        tfResult.setText(String.format("%.2f", result));
    }

    private void multiply() {
        double n1 = Double.parseDouble(tfN1.getText());
        double n2 = Double.parseDouble(tfN2.getText());

        double result = n1 * n2;

        tfResult.setText(String.format("%.2f", result));
    }

    private void divide() {
        double n1 = Double.parseDouble(tfN1.getText());
        double n2 = Double.parseDouble(tfN2.getText());

        double result = n1 / n2;

        tfResult.setText(String.format("%.2f", result));
    }
}
