package hust.soict.globalict.aims.screen;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store.Store;


public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.setTitle("Add CD to Store");
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        CompactDisc cd = new CompactDisc(title, category, cost);
        store.addMedia(cd);
        this.close(); // Đóng cửa sổ sau khi thêm
    }
}