package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.logging.Logger;

public class TrackTest {
    public static void main(String args[]) {
        /**
         * example 3.13
         */
        List<Track> tracks = Arrays.asList(
                new Track(524, "Bakai"),
                new Track(333, "Violets for your furts"),
                new Track(666, "Time war"));
        //method Optional.get() return obj from the Optional
        Track longestTrack = tracks.stream().max(Comparator.comparing(t -> t.getLength())).get();

        Logger.getGlobal().info("3.13" + longestTrack.getName());

        /**
         * Example 3.14 rewrite 3.13
         */
        tracks = Arrays.asList(
                new Track(524, "Bakai"),
                new Track(333, "Violets for your furts"),
                new Track(666, "Time war"));
        longestTrack = tracks.get(0);
        for (Track track : tracks) {
            if (track.getLength() > longestTrack.getLength()) {
                longestTrack = track;
            }

        }
        Logger.getGlobal().info("3.14" + longestTrack.getName());

        /**
         * Example 3.15 which rewrite example 3.14
         */
        Track obj = tracks.stream().reduce(tracks.get(0), (x, y) -> x.getLength() > y.getLength() ? x : y);

        Logger.getGlobal().info("3.15" + obj.getName());
    }

}
