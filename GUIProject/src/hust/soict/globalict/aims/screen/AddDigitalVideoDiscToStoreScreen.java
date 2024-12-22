package hust.soict.globalict.aims.screen;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store.Store;


public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.setTitle("Add DVD to Store");
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
        store.addMedia(dvd);
        this.close(); // Đóng cửa sổ sau khi thêm
    }
}