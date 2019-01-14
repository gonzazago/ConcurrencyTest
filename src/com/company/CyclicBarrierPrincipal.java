package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierPrincipal {

    public static  void main(String... args){
        int participantes = 100;
        CarreraCyclicBarrier.setCarreras(participantes);

        Runtime runtime = Runtime.getRuntime();

        int nNucleos = runtime.availableProcessors();

        ExecutorService pool = Executors.newCachedThreadPool();

        for(int i = 0; i<participantes;i++){
            Runnable runnable = new CarreraCyclicBarrier(i);
            pool.execute(runnable);
        }

        pool.shutdown();

        while (!pool.isTerminated()){
            double [][] tiempos = CarreraCyclicBarrier.getTiempos();


            int idGanador = 0;
            double ganadorTiempo =  tiempos[0][3];

            int idGanador1 = 0;
            double ganadorTiempo1 =  tiempos[0][0];

            int idGanador2 = 0;
            double ganadorTiempo2 =  tiempos[0][1];

            int idGanador3 = 0;
            double ganadorTiempo3 =  tiempos[0][2];


            for(int i = 0; i<tiempos.length;i++){
                if(tiempos[i][3] < ganadorTiempo){
                    ganadorTiempo = tiempos[i][3];
                    idGanador = i;
                }

                if(tiempos[i][0] < ganadorTiempo1){
                    ganadorTiempo1 = tiempos[i][0];
                    idGanador1 = i;
                }

                if(tiempos[i][1] < ganadorTiempo2){
                    ganadorTiempo2 = tiempos[i][2];
                    idGanador2 = i;
                }

                if(tiempos[i][2] < ganadorTiempo3){
                    ganadorTiempo3 = tiempos[i][2];
                    idGanador3 = i;
                }
            }
            System.out.println("El ganador es el hilo.................: " + idGanador);
            System.out.println("El ganador de la etapa 1 es el hilo...: " + idGanador1);
            System.out.println("El ganador de la etapa 2 es el hilo...: " + idGanador2);
            System.out.println("El ganador de la etapa 3 es el hilo...: " + idGanador3);
        }


    }
}
