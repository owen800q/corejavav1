package stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapStream {

    public static void main(String[] args) {


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

    }
}
