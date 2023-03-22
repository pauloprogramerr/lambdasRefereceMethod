package com.lambdas.estudos;

import lombok.Data;
import lombok.NonNull;

import java.util.Arrays;
import java.util.stream.Collectors;

@Data
public class Person {

    public Person(){}
    public Person(String ... names){
        this.name = Arrays.stream(names)
                .collect(Collectors.joining(" "));
    }
    @NonNull
    private String name;

    public Person(Person person) {
        this.name = person.getName();
    }
}
