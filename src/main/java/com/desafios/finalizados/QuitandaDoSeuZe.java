package com.desafios.finalizados;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.DoubleStream;

public class QuitandaDoSeuZe {
    private static Scanner input = new Scanner(System.in);
    public static Function<Integer, Double> somaMacas = valMacas -> (valMacas > 5) ? valMacas * 1.5 : (valMacas * 1.8);
    public static Function<Integer, Double> somaMorangos = valMor -> (valMor > 5) ? valMor * 2.2 : (2.5 * valMor);

    public static void main(String ... args){
        int morangos = input.nextInt();
        int macas = input.nextInt();

        DoubleStream.of((somaMorangos.apply(morangos)
                        + somaMacas.apply(macas)))
                .map(y -> desconto(y, (morangos + macas)))
                .peek(System.out::println)
                .sum();
    }
    public static double desconto(double desconto, int qtd){
        if (qtd > 8 || desconto > 25)
            desconto -= .1 * desconto;
        return desconto;
    }
}