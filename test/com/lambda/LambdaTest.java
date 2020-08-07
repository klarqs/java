package com.lambda;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class LambdaTest {

    private Logger logger = Logger.getLogger(LambdaTest.class.getName());

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void wimpsSum() {
        int total = 0;
        for (int i = 1; i <= 10; i++) {
            total += i;
        }
        assertEquals(55, total);
    }

    @Test
    void geesSum() {
        int total = IntStream.rangeClosed(1, 10)
                             .sum();
        assertEquals(55, total);
    }

    @Test
    void wimpsEvenNumberSum() {
        int total = 0;
        for (int i = 2; i <= 20; i+=2){
            total += i;
        }
        assertEquals(110, total);
    }

    @Test
    void geesEvenNumberSum() {
        int total = IntStream.rangeClosed(1, 10)
                 .map((int x) -> {return x * 2;})
                 .sum();
        assertEquals(110, total);
//        logger.info(String.valueOf(total));
    }

    @Test
    void geesEvenNumber_Sum() {
        int total = IntStream.rangeClosed(1, 10)
                .map(x -> x * 2)
                .sum();
        assertEquals(110, total);
//        logger.info(String.valueOf(total));
    }

    @Test
    void wimpsFiltering() {
        int total = 0;
        for (int i = 1; i <= 10; i++){
            if (i % 2 == 0) {
                total += (i * 3);
            }
        }
        assertEquals(90, total);
    }

    @Test
    void geesFiltering() {
        int total = IntStream.rangeClosed(1, 10)
                             .filter(x -> x % 2 == 0)
                             .map(x -> x * 3)
                             .sum();
        assertEquals(90, total);
    }

    @Test
    void randomInteger() {
        SecureRandom randomNumbers = new SecureRandom();
        System.out.println("Random numbers on separated lines:");
        randomNumbers.ints(10, 1, 7)
                     .forEach(System.out::println);
        String numbers =
                randomNumbers.ints(10, 1,7)
                             .mapToObj(String::valueOf)
                             .collect(Collectors.joining(" "));
        System.out.printf("%nRandom numbers on one line: %s%n", numbers);
    }

    @Test
    void intStreamOperations() {
        int[] values = {3, 10, 6, 1, 4, 8, 2, 5, 9, 7};

        // display original values
        System.out.print("Original values: ");
        System.out.println(
                IntStream.of(values)
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(" ")));

        // count, min, max, sum and average of the values
        System.out.printf("%nCount: %d%n",
                IntStream.of(values)
                         .count());

        System.out.printf("Min: %d%n",
                IntStream.of(values)
                         .min()
                         .getAsInt());

        System.out.printf("Max: %d%n",
                IntStream.of(values)
                         .max()
                         .getAsInt());

        System.out.printf("Sum: %d%n",
                IntStream.of(values)
                         .sum());

        System.out.printf("Average: %.2f%n",
                IntStream.of(values)
                         .average()
                         .getAsDouble());

        // sum of values with reduce method
        System.out.printf("%nSum via reduce method: %d%n",
                IntStream.of(values)
                         .reduce(0, (x, y) -> x + y));

        // product of values with reduce method
        System.out.printf("Product via reduce method: %d%n",
                IntStream.of(values)
                         .reduce((x, y) -> x * y)
                         .getAsInt());

        // sum of squares of values with map and sum methods
        System.out.printf("Sum of squares via map and sum: %d%n%n",
                IntStream.of(values)
                         .map(x -> x * x)
                         .sum());

        // displaying the elements in sorted order
        System.out.printf("Values displayed in sorted order: %s%n",
                IntStream.of(values)
                         .sorted()
                         .mapToObj(String::valueOf)
                         .collect(Collectors.joining(" ")));
    }

    @Test
    void arraysAndStreams() {
        Integer[] values = {2, 9, 5, 0, 3, 7, 1, 4, 8, 6};

        // display original values
        System.out.printf("Original values: %s%n", Arrays.asList(values));

        // sort values in ascending order with streams
        System.out.printf("Sorted values: %s%n",
                Arrays.stream(values)
                      .sorted()
                      .collect(Collectors.toList()));

        // values greater than 4
        List<Integer> greaterThan4 =
                Arrays.stream(values)
                      .filter(value -> value > 4)
                      .collect(Collectors.toList());
        System.out.printf("Values greater than 4: %s%n", greaterThan4);

        // filter values greater than 4 then sort the results
        System.out.printf("Sorted values greater than 4: %s%n",
                Arrays.stream(values)
                      .filter(value -> value > 4)
                      .sorted()
                      .collect(Collectors.toList()));

        // greaterThan4 list sorted with stream
        System.out.printf("Values greater than 4 (ascending with streams): %s%n",
                greaterThan4.stream()
                            .sorted()
                            .collect(Collectors.toList()));
    }

    @Test
    void arraysAndStreams2() {
        String[] strings =
                {"Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet"};

        // display original strings
        System.out.printf("%Original strings: %s%n", Arrays.asList(strings));

        // strings in uppercase
        System.out.printf("strings in uppercase: %s%n",
                Arrays.stream(strings)
                      .map(String::toUpperCase)
                      .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted ascending
        System.out.printf("strings less than n sorted ascending: %s%n",
                Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER)
                      .collect(Collectors.toList()));

        // strings less than "n" (case insensitive) sorted descending
        System.out.printf("strings less than n sorted descending: %s%n",
                Arrays.stream(strings)
                      .filter(s -> s.compareToIgnoreCase("n") < 0)
                      .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                      .collect(Collectors.toList()));
    }



}
