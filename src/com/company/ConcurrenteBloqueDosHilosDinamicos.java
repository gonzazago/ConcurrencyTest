package com.company;

import java.util.Random;

public class ConcurrenteBloqueDosHilosDinamicos extends Thread {

    public static int tam = 15;
    public static int [][] mat = new int[tam][tam];


    int ini,fin;

    public ConcurrenteBloqueDosHilosDinamicos(int ini,int fin){
        this.ini=ini;
        this.fin=fin;
    }

    public void run(){

        for(int i = ini; i < fin;i++){
            for(int j = 0; j<mat[0].length;j++){
                mat[i][j] *=10;
            }
        }
    }

    public static void main(String... args){
        /*Informacion del hardware de donde se ejecuta la jvm*/
        Runtime runtime = Runtime.getRuntime();

        /*Recupero la cantidad de nucleos del procesador*/
        int nucleos = runtime.availableProcessors();

        Random ran = new Random(System.nanoTime());


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = ran.nextInt(10);
            }
        }

        /*Forma de declarar hilos dinamicos*/
        Thread[]hilos = new Thread[nucleos];

        /*variable para inicializar el rango*/
        int rango = tam/nucleos;
        int start = 0;
        int finish = rango;
        for(int i = 0; i<rango;i++){
            if(i != nucleos-1){
                hilos[i] = new ConcurrenteBloqueDosHilosDinamicos(start,finish);
                hilos[i].start();
                start=finish;
                finish+=rango;
            }else {
                hilos[i] = new ConcurrenteBloqueDosHilosDinamicos(start,tam);
                hilos[i].start();
            }

        }

        try {
            for(int i =0 ;i<nucleos;i++){
                hilos[i].join();
            }
        }catch (Exception e){}

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                System.out.print(mat[i][j] + " ");
            }
                System.out.println();
        }

    }
}
