package com.desafios.finalizados;

import java.util.Scanner;

public class SomaDeH_com_N_Temos {
    public static void main(String ... args){

        double h = 0.0;
        Scanner sc = new Scanner(System.in);
        double n = sc.nextDouble();

        for (int i = 1; i <= n; i++) {
            //TODO: Calcule o valor de H de forma que resulte na soma dos termos:
            h = h + 1.0 / i;
        }
        //TODO: Imprima a soma dos termos, considerando um resultado com duas casas decimais:
        System.out.printf("%d",Math.round(h));
    }
}
