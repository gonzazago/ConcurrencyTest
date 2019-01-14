package com.company;

import java.util.Random;

public class ConcurrenteBloqueDos extends Thread{
    public static int tam = 1000;
    public static int [][] mat = new int[tam][tam];


    int ini,fin;

    public ConcurrenteBloqueDos(int ini,int fin){
        this.ini=ini;
        this.fin=fin;
    }

    public void run(){

        for(int i = ini; i < fin;i++){
            for(int j = 0; j<mat[0].length;j++){
                mat[i][j] *=10;
            }
        }
    }

    public static void main(String... args) {
        double tini,tfin;
        Random ran = new Random(System.nanoTime());


        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                mat[i][j] = ran.nextInt(10);
            }
        }

        tini = System.nanoTime();// hora en nanoSegundos

        ConcurrenteBloqueDos t1 = new ConcurrenteBloqueDos(0, mat.length / 3);
        ConcurrenteBloqueDos t2 = new ConcurrenteBloqueDos(mat.length / 3, mat.length);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        }catch (Exception e){e.printStackTrace();}
        tfin = (System.nanoTime() - tini)/1000000;// hora en nanoSegundos

//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat.length; j++) {
//                System.out.print(mat[i][j] + " ");
//            }
//                System.out.println();
//        }

        System.out.println("Tiempo transcurrido: " + tfin);
    }
}
