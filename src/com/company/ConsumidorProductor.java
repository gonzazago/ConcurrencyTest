package com.company;

public class ConsumidorProductor implements  Runnable{

    private boolean consumidor;

    private static  int tarta = 0;
    private static Object look = new Object();

    public ConsumidorProductor(boolean consumidor){
        this.consumidor=consumidor;
    }

    @Override
    public void run(){

        while(true){
            if(consumidor){
                consumiendo();

            }else {
                cocinando();
            }
        }

    }

    private void consumiendo() {
        synchronized (look){
            if(tarta>0){
                tarta--;
                System.out.println("Quedan: " + tarta+" porciones de tarta");
                try {
                    Thread.sleep(1000);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else {
                look.notifyAll();
                try {
                    look.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    private void cocinando() {
        synchronized (look){
                if(tarta == 0){
                    tarta = 10;
                    System.out.println("Soy el cocinero y quedan: " + tarta);
                    look.notifyAll();
                }
                try {
                    look.wait();

                }catch (Exception e ){

                }
        }
    }

    public static void main(String... args){
        int numHilos = 11;
        Thread[]t = new Thread[numHilos];

        for(int i = 0; i< t.length;i++){
            Runnable runnable=null;
            if(i !=0){
                runnable= new ConsumidorProductor(true);
            }else{
                runnable= new ConsumidorProductor(false);
            }

            t[i]= new Thread(runnable);
            t[i].start();
        }

        for(int i = 0; i< t.length;i++){
            try {
                t[i].join();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
