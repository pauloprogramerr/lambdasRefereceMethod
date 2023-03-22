package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static org.junit.Assert.assertTrue;

public class RunBook {
    public static void main(String[] args) {
        Book book1 = new Book(1, "Modern Java Recipes");
        Book book2 = new Book(2, "Making Java Groovy");
        Book book3 = new Book(3, "Gradle Recipes for Android");

        List<Book> books = Arrays.asList(book1, book2, book3);

        HashMap<Integer, Book> bookMap = books.stream()
                .reduce(new HashMap<Integer, Book>(),
                        (map, book) -> {
                            map.put(book.getId(), book);
                            return map;
                        },
                        (map1, map2) -> {
                            map1.putAll(map2);
                            return map1;
                        });
        bookMap.forEach((k, v) -> System.out.println(k + ": "+ v));

        somandoBigDecimalComReduce();

    }
    public static void somandoBigDecimalComReduce(){
        BigDecimal total = Stream.iterate(BigDecimal.ONE,n -> n.add(BigDecimal.ONE))
                .limit(10)
                .reduce(BigDecimal.ZERO, (acc, val) -> acc.add(val));
        System.out.println("The total is " + total);

        List<String> strings = Arrays.asList(
                "this", "is", "a", "list", "of","strings");
        List<String> sorted = strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sorted);

        strings.stream()
                .reduce((prev, curr) -> {
                    assertTrue(prev.length() <= curr.length());
                    return curr;
                });
    }
}
