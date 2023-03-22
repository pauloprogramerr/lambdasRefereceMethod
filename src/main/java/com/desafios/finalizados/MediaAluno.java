package com.desafios.finalizados;

import java.util.Scanner;

public class MediaAluno {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        double v = Double.parseDouble(scanner.nextLine());

        if (v < 5) System.out.println("REP");
        else if ((v >= 5) && (v <= 7)) System.out.println("REC");
        else System.out.println("APR");
    }
}
