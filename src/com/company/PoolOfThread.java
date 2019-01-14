package com.company;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolOfThread implements Runnable {

    public static int tam = 20000;
    private int fila ;
    public static int [][] mat = new int[tam][tam];

    public PoolOfThread(int fila) {
        this.fila = fila;
    }

    @Override
    public void run() {
        for(int i = 0; i<tam;i++){
            mat[fila][i]*=10;
        }
    }
    public static void main(String... args) {
        Random ran = new Random(System.nanoTime());
        double tini,tfin;


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = ran.nextInt(10);
            }
        }
        tini = System.nanoTime();// hora en nanoSegundos

        Runtime runtime = Runtime.getRuntime();
        int nucleos = runtime.availableProcessors();
        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 0; i< tam; i++){
            Runnable runnable = new PoolOfThread(i);
            pool.execute(runnable);
        }

        pool.shutdown();
        while (!pool.isTerminated());

/*
        Thread[]hilos = new Thread[tam];

        for(int i = 0; i<hilos.length;i++){
            Runnable runnable = new PoolOfThread(i);
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }
        for(int i = 0; i<hilos.length;i++){
            try {
                hilos[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }*/

        tfin = System.nanoTime() -tini;
        System.out.println("Tiempo de ejecucion: " +tfin/1000000000 + "seg");
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat.length; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//            System.out.println();
//        }


    }
}
