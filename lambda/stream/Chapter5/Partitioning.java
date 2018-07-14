package stream.Chapter5;

import stream.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class Partitioning {
    /**
     * Using a Predicate to determine whether an element should be part of the true group or the false group
     *
     * @param artists
     * @return A map matching two types of list from true and false.
     */
     Map<Boolean, List<NewArtist>> isSoloAndBands(Stream<NewArtist> artists) {
        return artists.collect(Collectors.partitioningBy(NewArtist::isSolo));
    }


}

class TestPartitioning {
    public static void main(String args[]) {
        final Logger logger = LoggerFactory.getLogger(Partitioning.class);
        NewArtist aritist_1 = new NewArtist("kwan", "HK", true, false);
        NewArtist artist_2 = new NewArtist("wika", "HK", true, true);
        NewArtist artist_3 = new NewArtist("caca", "Japan", false, true);
        Stream<NewArtist> artists = Stream.of(aritist_1, artist_2, artist_3);
        Partitioning unit = new Partitioning();
        Map<Boolean, List<NewArtist>> result = unit.isSoloAndBands(artists);


        for (Map.Entry<Boolean, List<NewArtist>> row : result.entrySet())
        {
            row.getValue().stream().
                    forEach(artist ->
                    {
                        logger.info("{}  {}", row.getKey(), artist.getName());
                    });
        }

        /*
        Above map iteration can be changed to the following simplified expression
         */

        /**
         * Map.foreach(Key,Value )->{
         *     xxxxxx
         * }
         */
        result.forEach((solo,artist)->{
            artist.forEach(a->
                    {
                        logger.info("{}  {} ",solo,a.getName());
                    });
        });

    }
}
