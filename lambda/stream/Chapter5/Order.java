package stream.Chapter5;

import stream.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {


    public static void main(String args[]) {
        // //A collection with defined ordering
        final Logger logger = LoggerFactory.getLogger(Order.class);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> sameOrder = numbers.stream()
                                    .map(x -> x + 1)
                                    .collect(Collectors.toList());

        logger.info(String.valueOf(sameOrder.equals(Arrays.asList(2,3,4,5))));

        //A collection HashSet without ordering
        Set<Integer> numSet = new HashSet<>(numbers);
        Set<Integer> diffOrder = numSet.stream()
                                        .map(x->x+1)
                                        .collect(Collectors.toSet());
        logger.info((String.valueOf(numbers.equals(diffOrder))));
    }
}
