package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BufferPrincipal implements Runnable {

    private  int id;
    private static Buffer buffer = new Buffer();

    public BufferPrincipal(int id){
        this.id = id;
    }


    @Override
    public void run() {

        if(id == 0){
            int elemento;
            while (true){
                elemento = buffer.lee();

                if (elemento != -1){
                    System.out.println("Elemento extraido..: " + elemento);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else{
            while(true){
                buffer.escribir();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String... arg){

        Runtime runtime = Runtime.getRuntime();

        int nNucleos = runtime.availableProcessors();

        ExecutorService poolLector = Executors.newFixedThreadPool(nNucleos);

        for(int i = 0; i<nNucleos;i++){
            Runnable runnable = new BufferPrincipal(0);
            poolLector.execute(runnable);
        }

        poolLector.shutdown();

        ExecutorService poolEscritor = Executors.newFixedThreadPool(2);

        for(int i = 0; i<2;i++){
            Runnable runnable = new BufferPrincipal(1);
            poolEscritor.execute(runnable);
        }

        poolEscritor.shutdown();

        while (!poolLector.isTerminated());
    }
}
