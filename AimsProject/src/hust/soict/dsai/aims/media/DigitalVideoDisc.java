package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
    
    
	public DigitalVideoDisc(int id,String title, String category, String director, int length, float cost) {
		super(id, title, category, cost,length,director);
	}
	
	public boolean isMatch(String title) {
	    return this.getTitle().equalsIgnoreCase(title);
	}
	
	public void play() {
	    System.out.println("Playing Track: " + this.getTitle());
	    System.out.println("Track length: " + this.getLength());
	}

}