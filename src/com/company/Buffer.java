package com.company;

import java.util.Random;
import java.util.Vector;

public class Buffer {

    private Random random = new Random(System.nanoTime());

    private  int tam = 10;
    private  int pos = -1;

    private Vector<Integer> cola = new Vector();

    public synchronized int lee(){
        int elemento = -1;

        if(pos < 1){
            try {
                System.out.println("El hilo se va a dormir");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            elemento = cola.get(pos);
            cola.remove(pos);
            pos--;
        }
        return elemento;
    }

    public synchronized void escribir(){
        pos++;

        if(pos >= tam){

            System.out.println("Alcanzado limite de tamaño del vector!!!!");
//            new RuntimeException("el vector esta completo");
            pos--;
        }else {
            cola.add(generar());
            notifyAll();
        }
    }

    public synchronized int generar(){
        return random.nextInt(10);
    }
}
