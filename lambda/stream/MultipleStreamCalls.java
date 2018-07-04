package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class MultipleStreamCalls {
    public static void main(String args[]) {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Castle in the sky"));
        albums.add(new Album("Forever memory"));
        albums.add(new Album("Forever memory"));
       albums.get(0).addMusicians(new Artist("Thekwan", "Hong Kong"));
       albums.get(0).addMusicians(new Artist("wika", "London"));
       albums.get(0).addMusicians(new Artist("aaaa", "London"));
       albums.get(0).addMusicians(new Artist("Thebbbb", "London"));
        albums.get(0).addTrack(new Track(524, "Bakai"));
        albums.get(1).addTrack(new Track(333, "Violets for your furts"));
        albums.get(2).addTrack(new Track(32, "Time war"));
        //Stream misuse bad example
        List<Artist> musicians = albums.stream()
                .flatMap(Album::getMusicians)
                .collect(Collectors.toList());
        List<Artist> bands = musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(Collectors.toList());
        Set<String> origin= bands.stream()
                .map(artist -> artist.getOrigin())
                .collect(Collectors.toSet());
        //Good example
        String [] result=albums.stream()
                .flatMap(album -> album.getMusicians())
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getOrigin())
                .toArray(String[]::new);
        Logger.getGlobal().info(Arrays.toString(result));
    }

}
