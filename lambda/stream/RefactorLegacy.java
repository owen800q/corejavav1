package stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Refactor collection-based tasks to stream-based implementation
 */
public class RefactorLegacy {

    public static void main(String args[]) {

        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Castle in the sky"));
        albums.add(new Album("Forever memory"));
        albums.add(new Album("Forever memory"));
        albums.get(0).addTrack(new Track(524, "Bakai"));
        albums.get(1).addTrack(new Track(333, "Violets for your furts"));
        albums.get(2).addTrack(new Track(32, "Time war"));
        Set<String> aSet;

        //System.out.println(aSet);
        //Refactor the method findLongTracks
        aSet = nonNestedStreamOperation(albums);
        System.out.println(aSet);
        aSet = albums.stream()
                .flatMap(a -> (a.getTracks()).stream())
                .filter(t -> t.getLength() > 60)
                .map(t -> t.getName())
                .collect(Collectors.toSet());
        System.out.println(aSet);

    }

    static Set<String> normalFindLongTracks(List<Album> albums) {

        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (track.getLength() > 60) {
                    trackNames.add(track.getName());
                }
            }
        }
        return trackNames;
    }

    static Set<String> streamFindLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();

        albums.stream()
                .forEach(a -> a.getTracks()
                        .forEach(track -> {
                            if (track.getLength() > 60) {
                                trackNames.add(track.getName());
                            }
                        }));
        return trackNames;
    }

    /**
     * Another simple stream implementation.
     *
     * @param albums
     * @return
     */
    static Set<String> anotherStreamFindLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(a -> a.getTracks().stream()
                        .filter(t -> t.getLength() > 60)
                        .forEach(t -> {
                            trackNames.add(t.getName());
                        }));
        return trackNames;
    }

    //Total there have N X M streams
    //N: album stream M track stream
    protected static Set<String> mapAddSet(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .forEach(a -> {
                    a.getTracks().stream()
                            .filter(t -> t.getLength() > 60)
                            .map(t -> t.getName())
                            .forEach(name -> trackNames.add(name));
                });
        return trackNames;
    }

    protected static Set<String> nonNestedStreamOperation(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        albums.stream()
                .flatMap(a -> (a.getTracks()).stream())
                .filter(t -> t.getLength() > 60)
                .map(t -> t.getName())
                .forEach(name -> trackNames.add(name));
        ;
        return trackNames;
    }

}
