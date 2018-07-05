package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChapterThreeExercises {


    public static void main(String args[])
    {
        final Level level = Level.INFO;
        //test 1
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        Logger.getGlobal().log(level, () ->
                String.format("function: addUp return: %d", addUp(numbers)));

        //test 2
        Stream<Artist> artistStream = Stream.of(new Artist("kwan", "Hong Kong"), new Artist("wika", "London"));
        System.out.println(getNameAndOrigin(artistStream));

        //test 3
        List<Album>albumList=new ArrayList<>();
        albumList.add(new Album("Castle in the sky"));
        albumList.add(new Album("What the fuck"));
        albumList.get(0).addTrack(new Track(100,"track1"));
        albumList.get(0).addTrack(new Track(100,"track2"));
        albumList.get(0).addTrack(new Track(100,"track3"));
        albumList.get(1).addTrack(new Track(100,"track1"));
        getAlbumsWithAtMostThreeTracks(albumList.stream(),2).stream()
                .forEach(album -> System.out.println((album.getName())));


       //test 6
        Logger.getGlobal().info(String.valueOf(countLowercase("AbC")));

        //test 7
        Logger.getGlobal().info("@Test 7"+" "+find(Stream.of("ABC","abC","abc")));
    }

    /**
     * A function that adds up numbers
     */
    protected static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (x, y) -> x + y);
    }

    /**
     * A function that takes in artists and return a list of Strings
     */
    protected static List<String> getNameAndOrigin(Stream<Artist> artists) {
        return artists.map(artist -> artist.getName().concat(" " + artist.getOrigin())).collect(Collectors.toList());

    }
    /**
     * A function that takes in a stream of albums and returns a list of albums with at most three tracks.
     */
    protected static List<Album> getAlbumsWithAtMostThreeTracks(Stream<Album> albums,long limit)
    {
         return albums.filter(a->(long)a.getTracks().size()<=limit)
                 .collect(Collectors.toList());

    }
    //Convert this code sample from using external iteration to internal iteration.

/*
    public static int countBandMembersInternal(List<Artist> artists) {
        // NB: readers haven't learnt about primitives yet, so can't use the sum() method
        return artists.stream()
                .map(artist -> artist.getMembers().count())
                .reduce(0L, Long::sum)
                .intValue();

        //return (int) artists.stream().flatMap(artist -> artist.getMembers()).count();
    }
*/
/*Q3
    1. eager
    2.lazy
 */

/*Q4
    1. Yes
    2. No

 */

    //Q6
    private static int countLowercase(String str)
    {
      return (int)str.chars()
              .filter(c->c>='A' &&c<='Z')
              .count();
    }

    /**
     * A function that find a String with the largest number of lowercase letters
     */
   private static Optional<String> find(Stream<String> str)
   {
     return str.max(Comparator.comparing(s->countLowercase(s)));


   }


}