package org.example;

public interface Employee {
    String getFirst();
    String getLast();

    default String getName(){
        return String.format("%s %s", getFirst(), getLast());
    }
}
