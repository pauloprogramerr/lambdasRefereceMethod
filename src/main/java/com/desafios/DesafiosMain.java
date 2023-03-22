package com.desafios;

import java.util.Scanner;

// convertido para horas:minutos:segundos, 556 r: 0:9:16
// tempo de duração em segundos.


public class DesafiosMain {
    private static int sec;
    private static int min;
    private static int hour;
    private static Scanner input;
    public static void main(String[] args) {
        input = new Scanner(System.in);
        sec = 600;
        //sec = input.nextInt();
        hour = (sec / 100 / 60);
        min =  (sec / 60) % 60; // minutos ok
        sec = (sec % 60);

        System.out.println("Valor dos horas: " + hour);
        System.out.println("Valor dos minutos: "+min);
        System.out.println("Valor dos segundos: "+sec);

        System.out.println(hour+":"+min+ ":"+sec);
    }
}
