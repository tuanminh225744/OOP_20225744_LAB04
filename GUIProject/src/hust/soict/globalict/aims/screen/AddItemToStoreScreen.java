package hust.soict.globalict.aims.screen;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.store.Store.Store;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class AddItemToStoreScreen extends Stage {
    protected Store store;
    protected Cart cart;

    protected TextField tfTitle;
    protected TextField tfCategory;
    protected TextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTitle = new Label("Title:");
        tfTitle = new TextField();
        Label lblCategory = new Label("Category:");
        tfCategory = new TextField();
        Label lblCost = new Label("Cost:");
        tfCost = new TextField();

        pane.add(lblTitle, 0, 0);
        pane.add(tfTitle, 1, 0);
        pane.add(lblCategory, 0, 1);
        pane.add(tfCategory, 1, 1);
        pane.add(lblCost, 0, 2);
        pane.add(tfCost, 1, 2);

        Button btnAdd = new Button("Add");
        btnAdd.setOnAction(e -> addItem());
        pane.add(btnAdd, 1, 3);

        Scene scene = new Scene(pane, 400, 300);
        this.setScene(scene);
    }

    protected abstract void addItem(); // Mỗi lớp con sẽ triển khai phương thức này
}
