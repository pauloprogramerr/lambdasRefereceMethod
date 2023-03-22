package org.example;

import com.lambdas.estudos.PrintandoElementosDaColecao;
import com.lambdas.estudos.SortingStrings;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 1, 4, 1, 5, 9);
        boolean removed = nums.removeIf(n -> n <= 0);
        /*System.out.println("Elements were " + (removed ? "" : "NOT ") + "removed");
        nums.forEach(System.out::println);
*/
        //SortingStrings.testStrings();

        //PrintandoElementosDaColecao.elementosDaColecao();
        //PrintandoElementosDaColecao.usandoMathSupplier();
        PrintandoElementosDaColecao.encontrarUmNomeDeUmaColecao();

    }

}
