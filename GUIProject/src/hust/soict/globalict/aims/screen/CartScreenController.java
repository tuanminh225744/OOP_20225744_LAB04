package hust.soict.globalict.aims.screen;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.globalict.swing.StoreScreen;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private Cart cart;
    private Store store;

    @FXML
    private TableView<Media> tbMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;


    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;
    
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );
        updateTotalCost();
    }
    
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
    
    @FXML
    private void placeOrderPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Confirmation");
        alert.setHeaderText("Order Placed Successfully");
        alert.setContentText("Your order has been placed. Thank you for shopping with us!");
        alert.showAndWait();

        // Clear cart
        cart.emptyCart();
        updateTotalCost();
    }
    
    @FXML
    private Label lblTotalCost; // Nhãn hiển thị tổng giá trị giỏ hàng

    private void updateTotalCost() {
        float total = cart.totalCost(); // Gọi phương thức tính tổng giá trị từ Cart
        lblTotalCost.setText(String.format("%.2f$", total)); // Hiển thị tổng giá trị với 2 chữ số thập phân
    }
    
    @FXML
    void handleAddBook(ActionEvent event) {
        AddBookToStoreScreen addBookScreen = new AddBookToStoreScreen(store, cart);
        addBookScreen.show();
    }

    @FXML
    void handleAddCD(ActionEvent event) {
        AddCompactDiscToStoreScreen addCDScreen = new AddCompactDiscToStoreScreen(store, cart);
        addCDScreen.show();
    }

    @FXML
    void handleAddDVD(ActionEvent event) {
        AddDigitalVideoDiscToStoreScreen addDVDScreen = new AddDigitalVideoDiscToStoreScreen(store, cart);
        addDVDScreen.show();
    }

    @FXML
    void handleViewStore(ActionEvent event) {
        // Chuyển đến màn hình Store
        Platform.runLater(() -> {
            StoreScreen storeScreen = new StoreScreen(store); // Sử dụng store từ Cart
            storeScreen.setVisible(true);
        });
    }

    @FXML
    void handleViewCart(ActionEvent event) {
        // Chuyển đến màn hình Cart
        Platform.runLater(() -> {
            CartScreen cartScreen = new CartScreen(cart);
            cartScreen.setVisible(true);
        });
    }
}
