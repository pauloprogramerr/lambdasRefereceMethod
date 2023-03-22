package com.lambdas.estudos;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortingStrings {

    public static void testStrings(){
        List<String> bonds = Arrays.asList("Connery", "Lazenby", "Moore",
                "Dalton", "Brosnan", "Craig");

        // Ordem natural
        List<String> sorteds = bonds.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());

        System.out.println(sorteds);

        // Reverso lexicográfico

        sorteds = bonds.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sorteds);

        // Sorte nomes com Lowercase

        sorteds = bonds.stream()
                .sorted(Comparator.comparing(String::toLowerCase))
                .collect(Collectors.toList());
        System.out.println(sorteds);

        // Sorte pelo tamanho do nome

        sorteds = bonds.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sorteds);

        //

        sorteds = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
        System.out.println(sorteds);

    }
}
