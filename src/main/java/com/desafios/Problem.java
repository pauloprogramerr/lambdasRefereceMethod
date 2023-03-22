package com.desafios;

import java.util.Scanner;

class Problem {

    /*
           Exemplo de Entrada 	Exemplo de Saída

            16 2    O JOGO DUROU 10 HORA(S)
            0 0 	O JOGO DUROU 24 HORA(S)
            2 16 	O JOGO DUROU 14 HORA(S)
    */

    public static void main(String[] args){

        //complete os espaços em branco com sua solução para o problema

        Scanner scan = new Scanner(System.in);
        int inicio, fim, horas;
        inicio = 2 ; //scan.nextInt();
        fim = 16; //scan.nextInt();
        horas =  0 ;



        if(horas == 0){
            System.out.print("O JOGO DUROU 24 HORA(S)\n");
        }else if(horas < 10 ){
            System.out.print("O JOGO DUROU " + (horas ) + " HORA(S)\n");
        }else if(horas > 2 ){
            System.out.print("O JOGO DUROU " + (horas ) + " HORA(S)\n");
        }else{
            System.out.print("O JOGO DUROU " + (horas )  + " HORA(S)\n");
        }
    }
}