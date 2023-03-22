package com.lambdas.estudos;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class PrintandoElementosDaColecao {

    public static void elementosDaColecao(){
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");
        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        strings.forEach(s -> System.out.println(s));
        strings.forEach(System.out::println);
    }

    public static void usandoMathSupplier(){
        Logger logger = Logger.getLogger("...");

        DoubleSupplier randomSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random();
            }
        };
        randomSupplier = () -> Math.random();
        randomSupplier = Math::random;

        logger.info((Supplier<String>) randomSupplier);
    }

    public static void encontrarUmNomeDeUmaColecao(){
        List<String> names = Arrays.asList("Mal", "Wash", "Kaylee", "Inara", "Zoẽ",
                "Jayne", "Simon", "River", "Shepherd Book");

        Optional<String> first = names.stream()
                .filter(name -> name.startsWith("C"))
                .findFirst();
        System.out.println(first);
        System.out.println(first.orElse("None"));

        System.out.println(first.orElse(String.format("No result found in %s",
                names.stream()
                        .collect(Collectors.joining(", ")))));
        System.out.println(first.orElseGet(() ->
                String.format("No result found in %s",
                        names.stream()
                                .collect(Collectors.joining(", ")))));
    }
}
