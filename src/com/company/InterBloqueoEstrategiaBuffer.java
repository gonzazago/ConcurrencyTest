package com.company;

public class InterBloqueoEstrategiaBuffer implements Runnable {
    private  int id;
    private static Object cerrojoUno = new Object();
    private static Object cerrojoDos = new Object();
    private int cont_private = 0;
    private static int cont = 0;

    public InterBloqueoEstrategiaBuffer(int id) {
        this.id = id;
    }

    @Override
    public void run() {

        for(int i = 0; i<40000;i++){
            cont_private++;
        }

        synchronized (cerrojoUno){
            cont += cont_private;
        }
    }


    public static void main(String... args){
        Runtime runtime = Runtime.getRuntime();
        int nucleos = runtime.availableProcessors();
        Thread[] t = new Thread[nucleos];

        for (int i = 0 ; i< t.length; i++){
            Runnable runnable = new InterBloqueoEstrategiaBuffer(i);
            t[i]= new Thread(runnable);
            t[i].start();
        }

        for (int i = 0; i < t.length;i++){
            try{
                t[i].join();
            }catch (Exception e){ e.printStackTrace();}
        }

        System.out.println(cont);
    }
}
