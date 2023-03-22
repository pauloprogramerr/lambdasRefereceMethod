package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class RunMain {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara",
                "Zoe", "Jayne", "Simon", "River", "Shepherd Book");

        List<Integer> namesLengths = names.stream()
                .map(new Function<String, Integer>() {
                    public Integer apply(String s){
                        return s.length();
                    }
                })
                .collect(Collectors.toList());

        namesLengths = names.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.printf("nameLength = %s%n",namesLengths);

        //test();
        testRandom();
        stringsStream();
        testtest();
        operationMaxMin();
        concatenaString();
        collectingStringBuilder();

    }

    public static void test(){
        String names = Stream.of("Gomez", "Morticia", "Wednesday", "Pugsley")
                .collect(Collectors.joining(", "));
        System.out.println(names);

        String[] munsters = {"Herman", "Lily", "Eddie", "Marilyn", "Grandpa"};
        names = Arrays.stream(munsters)
                .collect(Collectors.joining(", "));
        System.out.println(names);

        List<BigDecimal> nums =
                Stream.iterate(BigDecimal.ONE, n -> n.add(BigDecimal.ONE))
                        .limit(10)
                        .collect(Collectors.toList());
        System.out.println(nums);

        Stream.iterate(LocalDate.now(), ld -> ld.plusDays(1L))
                .limit(10)
                .forEach(System.out::println);

        List<String> bradyBunch =  Arrays.asList("Greg", "Marcia", "Peter", "Jan",
                            "Bobby", "Cindy");
        names =  bradyBunch.stream()
                .collect(Collectors.joining(", "));
        System.out.println(names);

    }

    public static void testRandom(){

        List<Integer> ints = IntStream.range(10, 15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        List<Long> longs = LongStream.rangeClosed(10,15)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(longs);
    }

    public static void stringsStream(){
        List<String> strings = Stream.of("this", "is","a","list","of","strings")
                .collect(Collectors.toList());

        List<Integer> ints = IntStream.of(3, 1, 4, 1, 5, 9)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(ints);

        List<Integer> intss = IntStream.of(3, 1, 4, 1, 5, 9)
                .mapToObj(Integer::valueOf)
                .collect(Collectors.toList());
        System.out.println(intss);

    List<Integer> ints2 = IntStream.of(3, 1, 4, 1, 5, 9)
            .collect(ArrayList<Integer>::new, ArrayList::add, ArrayList::addAll);
        System.out.println(ints2);

    }
    public static void testtest(){
        String[] strings =  "this is an array of strings".split(" ");
        long counts = Arrays.stream(strings)
                .map(String::length)
                .count();
        System.out.println("there are " + counts + " strings");

        int totlaLegth = Arrays.stream(strings)
                .mapToInt(String::length)
                .sum();
        System.out.println("the total legth is " + totlaLegth);

        OptionalDouble ave = Arrays.stream(strings)
                .mapToInt(String::length)
                .average();
        System.out.println("the average legth is " + ave);

        OptionalInt max =Arrays.stream(strings)
                .mapToInt(String::length)
                .max();

        OptionalInt min = Arrays.stream(strings)
                .mapToInt(String::length)
                .min();

        System.out.println("the max is " + max + " and min is "+ min + " legth ");

        int sum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> {
                    System.out.printf("x = %d, y = %d%n", x, y);
                    return x + y;
                }).orElse(0);
        System.out.println("sum = " + sum);

        int doubleSum = IntStream.rangeClosed(1, 10)
                .reduce((x, y) -> x + 2 * y).orElse(0);
        System.out.println(doubleSum);

        // forma correta
        int intDoubleSum = IntStream.rangeClosed(1, 10)
                .reduce(0, (x, y) -> x + 2 * y);
        System.out.println(intDoubleSum);

        int sum1 = Stream.of( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(0, Integer::sum);
        System.out.println(sum1);
    }

    public static void operationMaxMin(){
        Integer max = Stream.of(3, 1, 4, 1, 5, 9)
                .reduce(Integer.MIN_VALUE, Integer::max);
        System.out.println("the max value is " + max);
    }

    public static void concatenaString(){
        String s = Stream.of("this", "is", "a", "list")
                .reduce("",String::concat);
        System.out.println(s);
    }

    public static void collectingStringBuilder(){
        String s = Stream.of("this", "is", "a", "list")
                .collect(() -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2))
                .toString();
        System.out.println(s);

        // Mesma aboradagem usando reference method
        String ss = Stream.of("this_", "is_", "a_", "list_")
                .collect(StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append)
                .toString();
        System.out.println(ss);

        // Mais simples seria usar o Joining da classe collectors
        String st = Stream.of("_this", "_is", "_a", "_list")
                .collect(Collectors.joining());
        System.out.println(st);
    }
}
