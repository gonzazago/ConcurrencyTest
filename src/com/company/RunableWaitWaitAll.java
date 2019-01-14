package com.company;

import java.util.Random;

public class RunableWaitWaitAll implements Runnable {
    private int id ;
    private static int count = 0;
    private static Random cerrojo= new Random();
    public RunableWaitWaitAll(int id) {
        this.id=id;
    }

        @Override
    public void run() {
        synchronized (cerrojo){
            while (id != count){
                try {
                    cerrojo.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Soy el hilo..: "+ id);
            count++;
            cerrojo.notifyAll();
        }
    }

    public static void main(String... args){
        Runtime runtime = Runtime.getRuntime();

        int nucleos = runtime.availableProcessors();

        Thread[] hilos = new Thread[nucleos];
        for (int i = 0; i < hilos.length;i++){
            Runnable runnable = new RunableWaitWaitAll(i);
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length;i++){
            try{
                hilos[i].join();
            }catch (Exception e){ e.printStackTrace();}
        }
        System.out.println("Soy el hilo principal");
    }
}
