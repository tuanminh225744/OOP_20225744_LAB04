package hust.soict.dsai.aims.media;

public class Track implements Playable {

	 private String title;  
	    private int length;   

	    public String getTitle() {
	        return title;
	    }

	    public int getLength() {
	        return length;
	    }

	    
	    public Track(String title, int length) {
	        this.title = title;
	        this.length = length;
	    }
	    
	    public void play() {
	        System.out.println("Playing DVD: " + this.getTitle());
	        System.out.println("DVD length: " + this.getLength());
	    }
	    
	    public boolean equals(Object o) {
	        if (this == o) return true; 
	        if (o == null || getClass() != o.getClass()) return false; 
	        Track track = (Track) o; 
	        return this.length == track.length && 
	               this.title != null && this.title.equalsIgnoreCase(track.title); 
	    }

}
