package hust.soict.dsai.aims.cart.Cart;

import java.util.Collections;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    
	public void addMedia(Media media) {
	    if (!itemsOrdered.contains(media)) {
	        itemsOrdered.add(media);
	        System.out.println(media.getTitle() + " has been added to the cart.");
	    } else {
	        System.out.println(media.getTitle() + " is already in the cart.");
	    }
	}

	public void removeMedia(Media media) {
	    if (itemsOrdered.contains(media)) {
	        itemsOrdered.remove(media);
	        System.out.println(media.getTitle() + " has been removed from the cart.");
	    } else {
	        System.out.println(media.getTitle() + " is not in the cart.");
	    }
	}
    
	public float totalCost() {
	    float total = 0;
	    for (Media media : itemsOrdered) {
	        total += media.getCost();
	    }
	    return total;
	}
	
	public void showCart() {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }

        System.out.println("Cart contents:");
        System.out.println("----------------------------------------");

        for (Media media : itemsOrdered) {
            System.out.println(media); 
        }

        System.out.println("----------------------------------------");
        System.out.println("Total cost: " + totalCost());
    }
    
	public Media getMediaById(int id) {
	    for (Media media : itemsOrdered) {
	        if (media.getId() == id) {
	            return media;
	        }
	    }
	    return null; 
	}
	
	public Media getMediaByTitle(String title) {
	    for (Media media : itemsOrdered) {
	        if (media.getTitle().equalsIgnoreCase(title)) {
	            return media;
	        }
	    }
	    return null; 
	}
	
	public void sortMediasByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart has been sorted by title and cost.");
    }

    public void sortMediasByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart has been sorted by cost and title.");
    }
    
    public ObservableList<Media> getItemsOrdered() {
        return FXCollections.observableArrayList(itemsOrdered);
    }
    
    public void emptyCart() {
        itemsOrdered.clear(); 
    }
}
