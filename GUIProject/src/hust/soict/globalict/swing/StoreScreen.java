package hust.soict.globalict.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;

public class StoreScreen extends JFrame {
	private static final long serialVersionUID = 1L;
	private Store store;
	private Cart cart;
	JPanel createNorth() {
	    JPanel north = new JPanel();
	    north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
	    north.add(createMenuBar());
	    north.add(createHeader());
	    return north;
	}

	JMenuBar createMenuBar() {
	    JMenu menu = new JMenu("Options");

	    JMenu smUpdateStore = new JMenu("Update Store");
	    smUpdateStore.add(new JMenuItem("Add Book"));
	    smUpdateStore.add(new JMenuItem("Add CD"));
	    smUpdateStore.add(new JMenuItem("Add DVD"));

	    menu.add(smUpdateStore);
	    menu.add(new JMenuItem("View store"));
	    menu.add(new JMenuItem("View cart"));

	    JMenuBar menuBar = new JMenuBar();
	    menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
	    menuBar.add(menu);

	    return menuBar;
	}
	
	JPanel createHeader() {
	    JPanel header = new JPanel();
	    header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

	    JLabel title = new JLabel("AIMS");
	    title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
	    title.setForeground(Color.CYAN);

	    JButton cart = new JButton("View cart");
	    cart.setPreferredSize(new Dimension(100, 50));
	    cart.setMaximumSize(new Dimension(100, 50));

	    header.add(Box.createRigidArea(new Dimension(10, 10)));
	    header.add(title);
	    header.add(Box.createHorizontalGlue());
	    header.add(cart);
	    header.add(Box.createRigidArea(new Dimension(10, 10)));

	    return header;
	}

	JPanel createCenter() {
	    JPanel center = new JPanel();
	    center.setLayout(new GridLayout(3, 3, 2, 2));

	    ArrayList<Media> mediaInStore = store.getItemsInStore();
	    for (int i = 0; i < mediaInStore.size(); i++) {
	        Media media = mediaInStore.get(i);

	        // Tạo giao diện cho từng media
	        JPanel cell = new JPanel();
	        cell.setLayout(new BoxLayout(cell, BoxLayout.Y_AXIS));

	        JLabel title = new JLabel(media.getTitle());
	        JLabel category = new JLabel(media.getCategory());
	        JLabel cost = new JLabel(String.format("$%.2f", media.getCost()));

	        JButton addToCartButton = new JButton("Add to cart");
	        addToCartButton.addActionListener(e -> {
	            cart.addMedia(media);
	            System.out.println("Added to cart: " + media.getTitle());
	        });
	        
	        cell.add(title);
	        cell.add(category);
	        cell.add(cost);
	        cell.add(addToCartButton);

	        center.add(cell); // Thêm ô vào bảng
	    }

	    return center;
	}
	
	public StoreScreen(Store store) {
        this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }
	
	
	
	
}
