package com.desafios.finalizados;

import java.io.IOException;
import java.util.Scanner;

public class PositivoMedia {

    public static void main(String[] args) throws IOException {

        Scanner leitor = new Scanner(System.in);
        int cont = 0;
        double media = 0;
        double x;

        //TODO: Implemente as condições adequadas para obter a quantidade de valores positivos e a média dos valores positivos:
        for (int i = 1; i <= 6; i++) {
            x = Double.parseDouble(leitor.nextLine());
                if (x > 0) {
                    cont++;
                    media = media + x;
                }
        }
        media = media / cont;
        System.out.println(cont + " valores positivos");
        System.out.println(String.format("%.1f", media));
    }
}
