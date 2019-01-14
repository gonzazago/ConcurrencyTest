package com.company;

import java.util.*;

public class RappiTest {

    public static List<Integer> noPair(List<String> words){
        List<Integer> res = new ArrayList<>();
        Integer pairs = 0;

        for(String s : words){

            if(s.length() == 2){
                if(s.charAt(0) == s.charAt(1)){
                    res.add(1);
                }
            }else{
                for(int i = 0; i < s.length()-2;i++){
                    if(i < s.length()){
                        if(s.charAt(i) == s.charAt( i+1)){
                            if(i == 0){
                                pairs++;
                            }else if( s.charAt(i) != s.charAt(i-1) ){
                                pairs++;
                            }
                       }
                    }
                }
            }
            if (pairs > 0) {
                res.add(pairs);
            } else {
                res.add(0);
            }

            pairs = 0;
        }

        return res;
    }



    public static void main(String... args){
//        List<String> input = new ArrayList<>(Arrays.asList(
//                "keyhbmeknckfavrpqyyfjxjjmivtsftikovkcdcwefctqrqjryhtlcvstm",
//                "rpqipvntglpsbmoyxpjhkfufrxgnqjvhtizxn",
//                "sddpeibedjk",
//                "dkxqcthvgmzymoohniertqanrbkfdolfwfaalwolqpipngsaquxurvzwjpfejkfyys",
//                "jdzsnpejkyqktrdlljfuozlfsvrhqrwgtojnxllzmbfvoexxxttzcbprwzyztsovcxootxoswbffcokhtosfvn",
//                "hwqfvaiqxdksxvbtcr",
//                "bsdmsblyvzulromgbvteqxqahed",
//                "geptwdurphheydbyxrm",
//                "rplpqbzsnpotqwmcrdyckzfyghzz"
//                ));

//        List<String> input = new ArrayList<>(Arrays.asList(
//                "sofkfrrvoqaakwzksohvmnncpfgblidcsclggmghighzzhrjhmnvdkgxsloi",
//                "mxrghbmoqwoajqcaqzqxinbjtnkywtbxwjmqatmct",
//                "apgythaslgwdjdwvkrzgxbwluhlopfrelci",
//                "qjqswxhvmlwecxrnnvuqgydcduvjxohelcwyawvecoltdwgueqloivvtkadsabdlcnxpnybxjfhnoplllvoxwwopvhord",
//                "jtepxcmubqbitxzzplidjenuoaulbkpktfglkmfvcknxqmeyu",
//                "ftfaqndypcxejvxiosgojdmfccpk",
//                "ubtkhbuzmlqkpbbbwrvstnjvxjbtncbwzorusdnzmkbdjvyhzzvugnchsy",
//                "fhymcsiltwjjiownaszuwbnaeorpimjfwt"
////                "plllp"
//        ));

        List<String> input = new ArrayList<>(Arrays.asList(
                "ab",
                "aab",
                "abb",
                "abab",
                "abaaaaba"
        ));

        List<Integer> res = noPair(input);
                for(Integer  in : res){
                    System.out.println(in);
                }
    }
}
