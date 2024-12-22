package hust.soict.dsai.aims.Aims;
import java.util.ArrayList;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store.Store;
import hust.soict.globalict.aims.screen.CartScreen;
import hust.soict.globalict.swing.StoreScreen;

public class Aims {
	
//	public static void showMenu() {
//        System.out.println("AIMS: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. View store");
//        System.out.println("2. Update store");
//        System.out.println("3. See current cart");
//        System.out.println("0. Exit");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2-3: ");
//    }
//
//    public static void storeMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. See a media’s details");
//        System.out.println("2. Add a media to cart");
//        System.out.println("3. Play a media");
//        System.out.println("4. See current cart");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2-3-4: ");
//    }
//
//    public static void mediaDetailsMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Add to cart");
//        System.out.println("2. Play");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2: ");
//    }
//
//    public static void cartMenu() {
//        System.out.println("Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Filter medias in cart");
//        System.out.println("2. Sort medias in cart");
//        System.out.println("3. Remove media from cart");
//        System.out.println("4. Play a media");
//        System.out.println("5. Place order");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
//    }
//    
//    public static void updateStoreMenu() {
//    	System.out.println("Update Store Options: ");
//        System.out.println("--------------------------------");
//        System.out.println("1. Add a media to the store");
//        System.out.println("2. Remove a media from the store");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2: ");
//    }
//    
//    public static void filterMediasMenu() {
//    	System.out.println("Filter options: ");
//    	System.out.println("--------------------------------");
//        System.out.println("1. By ID");
//        System.out.println("2. By Title");
//        System.out.println("0. Back");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2: ");
//    }
//    
//    public static void sortMediasMenu() {
//    	System.out.println("Sort options: ");
//    	System.out.println("--------------------------------");
//        System.out.println("1. By Title");
//        System.out.println("2. By Cost");
//        System.out.println("--------------------------------");
//        System.out.print("Please choose a number: 0-1-2: ");
//    }
//	
//    public static void main(String[] args) {
//    	Scanner scanner = new Scanner(System.in);
//        
//        Store store = new Store();
//        Cart cart = new Cart();
//        
//     
//        
//        store.addMedia(new Book(0, "The Great Gatsby", "Novel", 10.99f, new ArrayList<>()));
//        store.addMedia(new DigitalVideoDisc(1, "The Godfather", "Crime", "Francis Ford Coppola", 175, 19.99f));
//        store.addMedia(new DigitalVideoDisc(2, "The Godfather 2", "Crime", "Francis Ford Coppola", 175, 25.99f));
//        store.addMedia(new CompactDisc(3, "Thriller", "Music", 15.99f, "Michael Jackson"));
//        store.addMedia(new Book(4, "1984", "Dystopian", 9.99f, new ArrayList<>()));
//
//        int choice;
//        do {
//            showMenu();
//            choice = scanner.nextInt();
//            scanner.nextLine(); 
//            switch (choice) {
//                case 1: 
//                    store.showMedias();
//                    storeMenu();
//                    int storeChoice = scanner.nextInt();
//                    scanner.nextLine(); 
//                    switch (storeChoice) {
//                        case 1: 
//                            System.out.print("Enter media title: ");
//                            String title = scanner.nextLine();
//                            Media media = store.getMediaByTitle(title);
//                            if (media != null) {
//                                System.out.println(media);
//                                mediaDetailsMenu();
//                                int mediaChoice = scanner.nextInt();
//                                scanner.nextLine();
//                                if (mediaChoice == 1) {
//                                    cart.addMedia(media);
//                                } else if (mediaChoice == 2) {
//                                	if (media instanceof CompactDisc) {
//                                	    CompactDisc cd = (CompactDisc) media;  
//                                	    cd.play();  
//                                	} else if (media instanceof DigitalVideoDisc) {
//                                	    DigitalVideoDisc dvd = (DigitalVideoDisc) media;  
//                                	    dvd.play();  
//                                    } else {
//                                        System.out.println("This media cannot be played. It is not a CD or DVD.");
//                                    }
//                                }
//                            } else {
//                                System.out.println("Media not found.");
//                            }
//                            break;
//                        case 2: 
//                            System.out.print("Enter media title: ");
//                            title = scanner.nextLine();
//                            media = store.getMediaByTitle(title);
//                            if (media != null) {
//                                cart.addMedia(media);
//                            } else {
//                                System.out.println("Media not found.");
//                            }
//                            break;
//                        case 3: 
//                            System.out.print("Enter media title to play: ");
//                            title = scanner.nextLine();
//                            media = store.getMediaByTitle(title);
//                            if (media != null) {
//                            	if (media instanceof CompactDisc) {
//                            	    CompactDisc cd = (CompactDisc) media;  
//                            	    cd.play();  
//                            	} else if (media instanceof DigitalVideoDisc) {
//                            	    DigitalVideoDisc dvd = (DigitalVideoDisc) media;  
//                            	    dvd.play();  
//                                } else {
//                                    System.out.println("This media cannot be played. It is not a CD or DVD.");
//                                }
//                            } else {
//                                System.out.println("Media not found.");
//                            }
//                            break;
//                        case 4: 
//                            cart.showCart();
//                            break;
//                        case 0:
//                            break;
//                    }
//                    break;
//                case 2: 
//                	updateStoreMenu();
//                    int updateStoreChoice = scanner.nextInt();
//                    scanner.nextLine(); 
//                    switch (updateStoreChoice) {
//                        case 1: 
//                        	System.out.print("Enter media type (Book/CD/DVD): ");
//                            String mediaType = scanner.nextLine();
//                            System.out.print("Enter id: ");
//                            int id = scanner.nextInt();
//                            scanner.nextLine();
//                            System.out.print("Enter title: ");
//                            String title = scanner.nextLine();
//                            System.out.print("Enter category: ");
//                            String category = scanner.nextLine();
//                            System.out.print("Enter cost: ");
//                            float cost = scanner.nextFloat();
//                            scanner.nextLine(); 
//                            
//                            Media newMedia = null;
//                            if (mediaType.equalsIgnoreCase("Book")) {
//                                newMedia = new Book(id, title, category, cost, new ArrayList<>());
//                            } else if (mediaType.equalsIgnoreCase("CD")) {
//                                System.out.print("Enter artist: ");
//                                String artist = scanner.nextLine();
//                                newMedia = new CompactDisc(id, title, category, cost, artist);
//                            } else if (mediaType.equalsIgnoreCase("DVD")) {
//                                System.out.print("Enter length: ");
//                                int length = scanner.nextInt();
//                                scanner.nextLine();
//                                System.out.print("Enter director: ");
//                                String director = scanner.nextLine();
//                                newMedia = new DigitalVideoDisc(id, title, category, director, length, cost);
//                            }
//
//                            if (newMedia != null) {
//                                store.addMedia(newMedia);
//                            } else {
//                                System.out.println("Invalid media type. Media not added.");
//                            }
//                            break;
//                        case 2: 
//                        	System.out.print("Enter title of the media to remove: ");
//                            String removeTitle = scanner.nextLine();
//                            
//                            Media mediaToRemove = store.getMediaByTitle(removeTitle);
//                            if (mediaToRemove != null) {
//                                store.removeMedia(mediaToRemove);
//                            } else {
//                                System.out.println("Media not found in store.");
//                            }
//                            break;
//                        case 0:
//                            break;
//                    }
//                    break;
//                case 3: 
//                    cart.showCart();
//                    cartMenu();
//                    int cartChoice = scanner.nextInt();
//                    scanner.nextLine(); 
//                    switch (cartChoice) {
//                        case 1:
//                        	filterMediasMenu();
//                        	int filterMediasChoice = scanner.nextInt();
//                            scanner.nextLine(); 
//                            switch (filterMediasChoice) {
//                            	case 1:
//                            		System.out.print("Enter media ID: ");
//                                    int id = scanner.nextInt();
//                                    scanner.nextLine(); 
//                                    Media mediaById = cart.getMediaById(id);
//                                    if (mediaById != null) {
//                                        System.out.println(mediaById);
//                                    } else {
//                                        System.out.println("Media not found.");
//                                    }
//                                    break;
//                            	case 2:
//                            		System.out.print("Enter media title: ");
//                                    String title = scanner.nextLine();
//                                    Media mediaByTitle = cart.getMediaByTitle(title);
//                                    if (mediaByTitle != null) {
//                                        System.out.println(mediaByTitle);
//                                    } else {
//                                        System.out.println("Media not found.");
//                                    }
//                                    break;
//                            	case 0:
//                            		break;
//                            }
//                            break;
//                        case 2:
//                        	sortMediasMenu();
//                        	int sortMediasChoice = scanner.nextInt();
//                            scanner.nextLine(); 
//                            switch (sortMediasChoice) {
//                            	case 1:
//                            		cart.sortMediasByTitle();
//                            		cart.showCart();
//                                    break;
//                            	case 2:
//                            		cart.sortMediasByCost();
//                                    cart.showCart();
//                                    break;
//                            	case 0:
//                            		break;
//                            }
//                            break;
//                        case 3:
//                        	System.out.print("Enter media title to remove: ");
//                            String removeTitle = scanner.nextLine();
//                            Media mediaToRemove = cart.getMediaByTitle(removeTitle);
//                            cart.removeMedia(mediaToRemove);   
//                            break;
//                        case 4:
//                        	System.out.print("Enter media title to play: ");
//                            String title = scanner.nextLine();
//                            Media media = store.getMediaByTitle(title);
//                            if (media != null) {
//                            	if (media instanceof CompactDisc) {
//                            	    CompactDisc cd = (CompactDisc) media;  
//                            	    cd.play();  
//                            	} else if (media instanceof DigitalVideoDisc) {
//                            	    DigitalVideoDisc dvd = (DigitalVideoDisc) media;  
//                            	    dvd.play();  
//                                } else {
//                                    System.out.println("This media cannot be played. It is not a CD or DVD.");
//                                }
//                            } else {
//                                System.out.println("Media not found.");
//                            }
//                            break;
//                        case 5:
//                            System.out.println("Order placed. Cart is empty.");
//                            cart = new Cart(); 
//                            break;
//                        case 0:
//                            break;
//                    }
//                    break;
//                case 0: 
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        } while (choice != 0);
//
//        scanner.close();
//    }
	public static void main(String[] args) {
        // Khởi tạo Cart
        Cart cart = new Cart();

        // Thêm một số Media vào Cart
        cart.addMedia(new Book("Book Title", "Novel", 19.99f));
        cart.addMedia(new CompactDisc("CD Title", "Music", 9.99f));
        cart.addMedia(new DigitalVideoDisc("DVD Title", "Movie", 14.99f));

        // Hiển thị CartScreen
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CartScreen(cart).setVisible(true);
            }
        });
    }
}
   

