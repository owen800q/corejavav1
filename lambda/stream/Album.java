package stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Album {

    private String name;


    private ArrayList<Track> tracks;
    private ArrayList<Artist> musicians;


    public Album(String name) {
        this.name = name;
        this.musicians = new ArrayList<>();
        this.tracks = new ArrayList<>();
    }

    /**
     * convert a list as a stream
     *
     * @return a stream
     */
    public Stream<Artist> getMusicians() {
        return this.musicians.stream();
    }

    // another
    public ArrayList<Artist> getMusician() {
        return this.musicians;
    }

    public void addMusicians(Artist obj) {
        this.musicians.add(obj);
    }


    protected  List<Track> getTracks(){return this.tracks;}


    protected void addTrack(Track track)
    {
        this.tracks.add(track);
    }

}
