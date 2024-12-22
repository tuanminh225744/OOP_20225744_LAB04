package hust.soict.globalict.aims.screen;


import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store.Store;


public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        this.setTitle("Add Book to Store");
    }

    @Override
    protected void addItem() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(title, category, cost);
        store.addMedia(book);
        this.close(); // Đóng cửa sổ sau khi thêm
    }
}