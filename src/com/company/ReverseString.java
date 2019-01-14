package com.company;

public class ReverseString {

    public static void reverseString(String input){

        StringBuilder sb = new StringBuilder(input);
        String output = sb.reverse().toString();

        System.out.println("Input:  "+ input);
        System.out.println("Output: "+ output);
    }


    public static void main(String[] arg){
        reverseString("Es una cadena");
    }


}
