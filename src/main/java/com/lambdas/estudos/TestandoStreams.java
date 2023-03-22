package com.lambdas.estudos;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class TestandoStreams {
    public static void testaStreams(){
        Stream.of(3,1,4,1,5,9)
                .forEach(x -> System.out.println(x));

        Stream.of(3,1,4,1,5,9)
                .forEach(System.out::println);
        Consumer<Integer> printer = System.out::println;
        Stream.of(3,1,4,1,5,9)
                .forEach(printer);

        Stream.generate(Math::random)
                .limit(10)
                .forEach(System.out::println);

/*  Equivalentes to System.out::println
            x -> System.out.println(x);
    Equivalente Math::max
            (x, y) -> Math.max(x, y);

    Equivalente String::length
        x -> x.legth();
 */
    }
}
