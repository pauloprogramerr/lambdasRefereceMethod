package com.desafios;

import java.util.*;
import java.util.stream.Collectors;

public class Animal {

    private static Scanner an1, an2, an3 = new Scanner(System.in);
    public static void animaisTest(){
/*

        String value1 = an1.next();
        String value2 = an2.next();
        String value3 = an3.next();
*/

        List<String> listVertebrado = Arrays.asList(
          "vertebrado", "ave", "carnivoro","onivoro",
           "mamifero","herbivoro");

        List<String> listInvertebrado = Arrays.asList(
          "invertebrado","inseto","hematofago","herbivoro",
          "anelideo","onivoro");

        HashMap<String, String> key = new HashMap<>();
        HashMap<String, String> values = new HashMap<>();
        String t = values.put("ave","carnivoro");
        key.put(t , t);

        String w = "vertebrado";

        List<String> list = Arrays.asList(String.valueOf(key));
        list.stream()
                .map(k -> key.containsKey("vertebrado"))
                .map(v -> values.containsKey("ave"))
                .map(s -> values.containsValue("arnivoro"))
                .sorted()
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }

    public static void testg(){

        String value1 = "vertebrado";
        String value2 = "mamifero";
        String value3 = "inseto";


        List<String> lista = Arrays.asList(value1, value2, value3);
        List<String> listVertebrado = Arrays.asList(
                "vertebrado", "ave", "carnivoro","onivoro",
                "mamifero","herbivoro");

        List<String> listInvertebrado = Arrays.asList(
                "invertebrado","inseto","hematofago","herbivoro",
                "anelideo","onivoro");

        Object ss = listVertebrado.stream()
                .limit(3)
                //.map(
                .collect(Collectors.toList());

        System.out.println(ss);

    }
}
