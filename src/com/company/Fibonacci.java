package com.company;

public class Fibonacci {

    private int res = 0;


    public static long FiboRecursivo(long pos){
        long retornado=0;
        if(pos==0 || pos==1){
            retornado=pos;
        }else{
            retornado=FiboRecursivo(pos-2)+FiboRecursivo(pos-1);
            System.out.println(retornado);
        }
        return retornado;
    }
    public static void main(String args[]){
        System.out.println(FiboRecursivo(7));
    }
}
