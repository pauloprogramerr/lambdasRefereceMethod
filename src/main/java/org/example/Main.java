package org.example;

import com.lambdas.estudos.LambdasAndReferenceMethod;
import com.lambdas.estudos.Person;
import com.lambdas.estudos.TestandoStreams;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static junit.framework.Assert.*;

public class Main {
    public static void main(String[] args) throws IOException {
        LambdasAndReferenceMethod l = new LambdasAndReferenceMethod();
        l.testandoArquivo();
        l.testandoComLambdas();
        l.testandoLambdas3();
        l.testandoLambdas4();

        TestandoStreams.testaStreams();

        LambdasAndReferenceMethod.multipleArgument();
        l.multipleArgumentStreamOf();

        Person before = new Person("Grace Hopper");

        List<Person> people = Stream.of(before)
                .collect(Collectors.toList());
        Person after = people.get(0);

        assertTrue(before == after);

        before.setName("Grace Murray Hopper");
        assertEquals("Grace Murray Hopper", after.getName());

        people = Stream.of(before)
                .map(Person::new)
                //.map(r -> new Person(before.getName()))
                .collect(Collectors.toList());
        after = people.get(0);
        assertFalse(before == after);
        assertEquals(before, after);

        before.setName("Rear Admiral Dr, Grace Murray Hopper");
        assertFalse(before.equals(after));


    }
}

