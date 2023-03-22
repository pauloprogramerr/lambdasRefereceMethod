package com.desafios.finalizados;


import java.util.Scanner;
import java.util.stream.IntStream;

public class Fibonnaci {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();

        IntStream.range(0, N)
                .map(s -> recursivo(s))
                .forEach(s -> System.out.print(s + " "));
    }
    public static int recursivo(int n) {
        if (n < 2) return n;
        return recursivo(n - 1) + recursivo(n - 2);
    }

    public static int mainTest()  {
        Scanner leitor = new Scanner(System.in);
        int N = leitor.nextInt();
        int proximo, anterior = 0, atual = 1;
        for (int i = 1; i <= N; i++) {
            if (i == N) System.out.println(anterior);
            else System.out.print(anterior + " ");
            proximo = anterior + atual;
            anterior = proximo - anterior;
            atual = proximo;
        }
        return atual;
    }

}

class Fibonnaci2 {
    public static void mainS(int n) {

        //Scanner input = new Scanner(System.in);
        //int n = input.nextInt();
        IntStream.range(0, n)
                .map(Fibonnaci2::recursivo)
                .forEach(i -> System.out.print(i + " "));
    }
    public static int recursivo(int n) {
        if (n <= 1)
            return n;
        return recursivo(n - 2) + recursivo(n - 1);
    }
}