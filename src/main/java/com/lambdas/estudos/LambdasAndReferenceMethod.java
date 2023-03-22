package com.lambdas.estudos;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdasAndReferenceMethod {
        File directory = new File("/home/pcgomes/Documentos/codidosSublime");
        public void testandoArquivo() throws IOException {
        String[] names = directory.list(new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                return name.endsWith(".java");
            }
        });
        System.out.println(Arrays.asList(names));
    }

    public void testandoComLambdas(){
       String[] names = directory.list((dir, name) -> name.endsWith(".class"));
        System.out.println(Arrays.asList(names));
    }

    public void testandoLambdas3(){
            String[] names = directory.list((File dir, String name) ->
                    name.endsWith(".java"));
        System.out.println(names);
    }

    public void testandoLambdas4(){
        String[] names = directory.list((File dir, String name) -> {
                    return name.endsWith(".class");
                });
        System.out.println(Arrays.asList(names));
    }

    public static void multipleArgument(){
        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorteds = strings.stream()
                                      .sorted((s1, s2) -> s1.compareTo(s2))
                .collect(Collectors.toList());
        System.out.println(sorteds);

        List<String> sortedss = strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortedss);


    }
    public void multipleArgumentStreamOf(){
        Stream.of("this", "is", "a", "list", "of", "strings")
                .map(String::length)
                .forEach(System.out::println);

        Stream.of("this", "is", "a", "list", "of", "strings")
                .map( s -> s.length())
                .forEach(x -> System.out.println(x));
    }

    public void transfereParaPerson(){
        List<String> names =
            Arrays.asList("Grace Hope", "Barbara Liskov", "Ada Lovelave", "Karen Sparck Jones");
        List<Person> people = names.stream()
                .map(name -> new Person(name))
                .collect(Collectors.toList());
        System.out.println(people);

        //          ou

        List<Person> people1 = names.stream()
                .map(Person::new)
                .collect(Collectors.toList());
        System.out.println(people1);

    }

    public void test(){
        List<String> names =
                Arrays.asList("Grace Hope", "Barbara Liskov", "Ada Lovelave", "Karen Sparck Jones");
        names.stream()
                .map(name -> name.split(" "))
                .map(Person::new)
                .collect(Collectors.toList());
        //System.out.println("Varargs ctor, names=" + Arrays.toList());

        Person[] people1 = names.stream()
                .map(Person::new)
                .toArray(Person[]::new);

    }
}
