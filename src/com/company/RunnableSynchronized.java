package com.company;

public class RunnableSynchronized implements Runnable{

    private static int count = 0;
    private  static Object object= new Object();
    @Override
    public void run(){
        synchronized (object){
        for(int i = 0 ;i<30000;i++){

                count++;
            };

        }
    }

    public static void main(String... args){

//        Runnable runnable = new RunnableSynchronized();

        Runtime runtime = Runtime.getRuntime();

        int nucleos = runtime.availableProcessors();

        Thread[] hilos = new Thread[nucleos];
        for (int i = 0; i < hilos.length;i++){
            Runnable runnable = new RunnableSynchronized();
            hilos[i] = new Thread(runnable);
            hilos[i].start();
        }

        for (int i = 0; i < hilos.length;i++){
            try{
                hilos[i].join();
            }catch (Exception e){ e.printStackTrace();}
        }

        System.out.println(count);


    }
}
