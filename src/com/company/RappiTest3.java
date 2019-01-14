package com.company;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class RappiTest3 {

    public static int [] rapiTest3(int[] nums, int []maxes){
        int countLess = 0;
        int [] resp = new int[maxes.length];
        int numMax = maximo(nums);
        int [] arrReducido = new int[]{};

        for(int i = 0; i< maxes.length;i++){
            int m = maxes[i];
            if(numMax <= m ){
                resp[i] =  nums.length;
            }else{
                arrReducido = reduceArr(nums,numMax);
                for(Integer i2 : arrReducido){
                    if(i2 <= m ){
                        countLess++;
                    }
                }
                resp[i]= countLess;
            }

            countLess = 0;
            arrReducido = new int[]{};
        }

        return resp;
    }

    public static int maximo(int [] arr){
        int numMax = 0;
        for(int i1 = 0; i1<arr.length; i1++){
            if(numMax < arr[i1]){
                numMax = arr[i1];
            }
        }
        return numMax;
    }

    public static  int[] reduceArr(int [] arr, int val){
        List<Integer> arrL = new ArrayList<>();
        for(int i = 0; i<arr.length;i++){
            if(arr[i]< val) {
                arrL.add(arr[i]);
            }
        }
        int[] arrReducido = new int[arrL.size()];
        int i2 = 0;
        for(int n : arrL){
            arrReducido[i2] = n;
            i2++;
        }
        return  arrReducido;
    }

    public static  void main(String... args){

        int[] nums = {1,4,2,4};
        int[] maxes = {3,5};

        int [] res = rapiTest3(nums,maxes);

        for(Integer i : res){
            System.out.println(i);
        }
    }
}
