package com.company;

public class Fibonacci2 {

    private int num = 5;

    public static void calcularFiobnacci(int n){

        long init = System.currentTimeMillis();
        for(int i = 0; i<n;i++){
            System.out.print(fibonacciRecursivo(i) + " , ");
        }

        long end = System.currentTimeMillis() - init;
        System.out.println("");
        System.out.println("Tiempo de ejecucion: " +end + " ms");
    }


    public static int fibonacciRecursivo(int n){

        int res = 0;
        if( n <= 1){
            return n;
        }else{
            res = fibonacciRecursivo( n -1) + fibonacciRecursivo( n-2);
            return res;
        }
    }


    public static int fibonacciIterativo(int rep){
        int n1= 0;
        int n2 = 1;
        long init = System.currentTimeMillis();

        System.out.print(n1 + ", ");
        System.out.print(n2 + ", ");
        for(int i = 0;i < rep; i++){
            n2 = n1 + n2;
            n1 = n2 - n1;
            System.out.print(n2 + " , ");

        }
        long end = System.currentTimeMillis() - init;
        System.out.println("");
        System.out.println("Tiempo de ejecucion: " +end + " ms");

        return n2;
    }


    public static void calcularFibonacci(String opc, int n){

        switch (opc){
            case "ITE":
                fibonacciIterativo(n);
                break;
            case "REC":
                calcularFiobnacci(n);
                break;
            default:
                System.out.println("OPCION INVALIDA");
        }
    }

    public static void main(String... args){

        calcularFibonacci("REC",40);
    }

}
