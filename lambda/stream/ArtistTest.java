package stream;


import java.lang.reflect.Array;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArtistTest {


    public static void main(String args[]) {
        ArrayList<Artist> allArtist = new ArrayList<>();
        allArtist.add(new Artist("kwan", "Hong Kong"));
        allArtist.add(new Artist("wika", "London"));
        allArtist.add(new Artist("aaaa", "London"));
        allArtist.add(new Artist("bbbb", "London"));
        int count = 0;
        /**
         * Counting London-based aritist using an iterator
         */
        Iterator<Artist> iterator = allArtist.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.getOrigin().equals("London")) {
                ++count;
            }

        }


        Logger.getGlobal().info("debug" + count);

        /**
         * stream-eager approach
         * Have a method at the end that generate a final value
         * The stream was divided into two parts
         * 1. filter all the artists from London
         * 2. Counting a list of artists.
         * lambda expression.
         */
        count = (int) allArtist.stream().filter(artist -> artist.getOrigin().equals("London")).count();
        Logger.getGlobal().info("lambda_stream" + " " + count);

        /**
         * The above streaming expression can be converted into the following expression
         */
        count = (int) allArtist.stream().filter(artist -> {
            return artist.isFrom("London");
        }).count();

        Logger.getGlobal().info("stream" + " " + count);

        /**
         * Stream-lazy approach
         * it does nothing.
         */
        allArtist.stream().filter(artist -> {
            Logger.getGlobal().info(artist.getName());
            return artist.isFrom("London");
        });

        /**
         * change to eager approach
         */
        count = (int) allArtist.stream().filter(artist -> {
            Logger.getGlobal().info("resukt" + " " + artist.getName());
            return artist.isFrom("London");
        }).count();

        //A list contains number 1 3 12 15
        ArrayList<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(3);
        numList.add(12);
        numList.add(15);
        /**
         * Finding the first number that is greater than 10 in a stream.
         */
        Optional<Integer> num = numList.stream().filter((Integer n) -> n > 10).findFirst();
        Logger.getGlobal().info("" + num);

        Stream.of("one", "two", "three", "four")
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        /**
         * Sequence of Stream calls (duplicated method)
         */
        List<String> list = Stream.of("1one", "2two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        //list.stream().forEach(System.out::println);
        /**
         * map accept a function
         */
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .forEach(System.out::println);
        /**
         * check if elements begin with digit.
         */
        list.stream().filter(c -> Character.isDigit(c.charAt(0)))
                .collect(Collectors.toList())
                .stream()
                .forEach(f -> System.out.println("String begin digit" + f));

    }


}




