package stream.Chapter4;

import stream.*;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class PritivesTest {
    public static void main(String args[]) {
        Album obj = new Album("Cstle in the sky");
        Stream<Track> tracks = Stream.of(
                new Track(524, "Bakai"),
                new Track(333, "Violets for your furts"),
                new Track(666, "Time war"));
        tracks.forEach(obj::addTrack);

        printTrackLengthStatistics(obj);

    }

    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats
                = album.getTracks().stream()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Count: %d, Max: %d, Min: %d, Avg: %f, Sum: %d",
                trackLengthStats.getCount(),
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
}
