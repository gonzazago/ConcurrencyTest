package com.company;

import java.util.Random;

public class PrincipalDinamico {

    private static int tam = 15;
    private static int[][] matriz = new int[tam][tam];

    private int inicio, fin;

    public PrincipalDinamico(int inicio, int fin){
        this.inicio = inicio;
        this.fin = fin;
    }

    public void run(){
        for(int i = inicio; i < fin; i++){
            for(int j = 0; j < matriz[0].length; j++){
                matriz[i][j] *= 10;
            }
        }
    }


    public static void main (String[] args){
        //Iniciar matriz
        Random rand = new Random(System.nanoTime());

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                matriz[i][j] = rand.nextInt(10);
            }
        }


        //Mostrar resultaod por pantalla
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[0].length; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
