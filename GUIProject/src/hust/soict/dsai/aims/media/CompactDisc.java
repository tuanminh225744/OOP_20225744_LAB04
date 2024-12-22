package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {

	private String artist; 
    private ArrayList<Track> tracks; 

    public String getArtist() {
        return artist;
    }

    
    public CompactDisc(int id,String title, String category, float cost, String artist) {
        super(id, title, category, cost, 0, ""); 
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }
    
    public CompactDisc(String title, String category, float cost) {
        super(0, title, category, cost, 0, ""); 
        this.tracks = new ArrayList<>();
    }

    
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists!");
        }
    }

    
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found!");
        }
    }

    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public void play() {
        System.out.println("Playing CD: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("CD length: " + this.getLength());
        
        for (Track track : tracks) {
            track.play(); 
        }
    }

}
