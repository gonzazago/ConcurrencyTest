package com.company;

import java.util.Random;

/*Para lanzar hilos se hace desde objetos que heredan de la clase thread
* Indeterminismo: dos o mas hilos estan escribiendo a la vez en una misma variable compartido
* el valor de la variable es indeterminado
* Seccion critica aquella parte del codigo en donde sabemos que se va a producir identerminismo*/
public class Principal extends Thread {
    int id;
    private static int tam = 100;
    private static int[] vec = new int[tam];

    private int ini,fin;

    public Principal(int ini,int fin){
        this.ini = ini;
        this.fin = fin;
    }
    public void run(){

        for(int i = ini; i< fin ;i++){
           vec[i] *= 10;
        }
    }
    public static void main(String... args){
        Random rand = new Random(System.nanoTime());
        Principal h1 = new Principal(0,vec.length/2);
        Principal h2 = new Principal(vec.length/2,vec.length);

        for(int i = 0; i< vec.length; i++){
            vec[i] = rand.nextInt(10);
        }
        h1.start();
        h2.start();
        try {
            h1.join();
            h2.join();
        }catch (Exception e){
            e.printStackTrace();
        }

        for(int i = 0; i< vec.length; i++){
            System.out.print(vec[i] + " ");
        }

    }
}
