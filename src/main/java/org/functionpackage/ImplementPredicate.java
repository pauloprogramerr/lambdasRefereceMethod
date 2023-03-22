package org.functionpackage;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ImplementPredicate {
    public static final Predicate<String> LENGTH_FIVE = s -> s.length()  == 5;
    public static final Predicate<String> STARTS_WITH_S = s -> s.startsWith("S");
    public String getNameSatisfyCondition(
        Predicate<String> condition,  String... names){
        return Arrays.stream(names)
                .filter(condition)
                .collect(Collectors.joining(", "));
    }
    public static String getNameOfLength(int length, String... names){
        return Arrays.stream(names)
                .filter(s -> s.length() == length)
                .collect(Collectors.joining(", "));
    }

    public String getNameStartingWith(String s, String... names){
        return Arrays.stream(names)
                .filter(a -> s.startsWith(s))
                .collect(Collectors.joining(", "));
    }
}
