package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String s = "hi";
        String s2 = "world";

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();



        for(char c : s.toCharArray()){
            set1.add(c);
        }

        for(char c : s2.toCharArray()){
            set2.add(c);
        }

        set1.retainAll(set2);

        System.out.println(contains(set1));

    }

    static String contains(Set<Character> s){
        return s.size() > 0 ? "YES" : "NO";
    }
}
