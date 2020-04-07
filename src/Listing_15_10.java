import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Listing_15_10 {
    public static void main(String[] args) {
        DoubleProperty balance = new SimpleDoubleProperty();
        balance.addListener(ov -> {
                System.out.println("The new value is " +
                        balance.doubleValue());
});

        balance.set(4.5);
    }
}
