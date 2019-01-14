package com.company;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


/*CyclicBarrierPrincipal barrera que coniene a los Hilos*/

public class CarreraCyclicBarrier implements Runnable{

    private int id;


    private double inicio;
    private double total;
    private Random random = new Random(System.nanoTime());
    private static CyclicBarrier barrier;
    private static double[][] tiempos;

    public CarreraCyclicBarrier(int id) {
        this.id = id;

    }

    public static void setCarreras(int participantes){
        tiempos = new double[participantes][4];
        barrier = new CyclicBarrier(participantes);
    }

    @Override
    public void run() {

        etapa(0);
        etapa(1);
        etapa(2);

        tiempos[id][3] = tiempos[id][0] + tiempos[id][1] +tiempos[id][2];


    }

    private void etapa(int numEtapa){
        //Etapa 1
        inicio = System.nanoTime();
        try {
            Thread.sleep(random.nextInt(100)+100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        total = System.nanoTime() - inicio;
        tiempos[id][numEtapa]= total;
        try {
            barrier.await();//detiene los hilos hasta que lleguen al numero de hilos pasado por parametros
            barrier.reset();//resetea
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


    public static double[][] getTiempos(){
        return  tiempos;
    }
}
