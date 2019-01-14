package com.company;

public class PrinicipalMonitores implements Runnable {
    private int id;

    public PrinicipalMonitores(int id){
        this.id = id;
    }

    private static  Monitores monitores = new Monitores();
    @Override
    public void run() {
        int cont =monitores.inc();
        System.out.println(cont);
        monitores.ordenar(id);

    }

    public static void main(String... args){
        Runtime runtime = Runtime.getRuntime();

        int nucleos = runtime.availableProcessors();

        Thread[] hilos = new Thread[nucleos];
        for (int i = 0; i < hilos.length;i++){
            Runnable runnable = new PrinicipalMonitores(i);
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
