package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RappiTestGit {

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
                "abaaaba"
        ));

        List<Integer> res = noPair(input);
        for(Integer  in : res){
            System.out.println(in);
        }
    }

    public static List<Integer> noPair(List<String> words){
        List<Integer> res = new ArrayList<>();
        for(String s : words){
            res.add(checkPairs(s));
        }

        return  res;
    }

    public static int checkPairs(String s){
        int maxPattern = 0;

        if(s.length() == 1)//Edge case where length is 1
        {
            return 0;
        }
        for(int i = 0; i < 26; i++)
        {
            nextLetter:
            for(int j = i + 1; j < 26; j++)
            {
                char one = (char) ('a' + i); //First char in pair
                char two = (char) ('a' + j); //Second char in pair
                char lastSeen = '\u0000';
                int patternLength = 0;

                for(char letter : s.toCharArray())
                {
                    if(letter == one || letter == two)
                    {
                        if(letter == lastSeen)//Duplicate found
                        {
                            continue nextLetter;
                        }
                        //Not a duplicate
                        patternLength++;
                        lastSeen = letter;
                    }
                }//for char : s

                maxPattern = (patternLength > maxPattern) ? patternLength : maxPattern; //Keep a running max

            }//for j
        }//for i

        return maxPattern;
    }

}
