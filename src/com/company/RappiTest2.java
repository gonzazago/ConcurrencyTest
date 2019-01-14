package com.company;

import java.util.HashSet;

public class RappiTest2 {

    public static String    GetSExpression(String s){

        boolean [][] graph = new boolean[26][26];
        HashSet<Character> nodes = new HashSet<>();

        boolean E2 = false;

        char[] s1 = s.toCharArray();
        for(int i=1;i<s1.length;i+=6){
            int x = s1[i]-'A', y = s1[i+2]-'A';
            if(graph[x][y]) //duplicate edge
                E2 = true;
                graph[x][y] = true;
                nodes.add(s1[i]);
                nodes.add(s1[i+2]);
        }

        //check error E1: more than 2 children
        boolean E1 = false;
        for(int i=0;i<26;i++){
            int count = 0; //number of child
            for(int j=0;j<26;j++){
                if(graph[i][j])
                count++;
            }
            if(count>2)
                return "E1";
        }

        if(E2) return "E2"; //return E2 after checking E1

        int numOfRoots = 0;
        char root =' ';
        for (char node : nodes){ //only check char that in the tree
            for(int i=0;i<26;i++){
                if(graph[i][node-'A'])
                break;
                if(i==25){
                    numOfRoots++;
                    root = node;
                    boolean[] visited = new boolean[26];
                    if(isCycle(node, graph, visited))
                        return "E3";
                }
            }
        }

        if(numOfRoots==0) return "E3"; //if no root, must be a cycle
        if(numOfRoots>1) return "E4"; //if more than one roots
        if(root==' ') return "E5"; //if no edge in input string, invalid input error
        return getExpressionHelper(root, graph);

    }

    //true means there is a cycle, false means no cycle
    public static boolean isCycle(char node, boolean[][] graph, boolean[] visited){
        if(visited[node-'A']) //node has already been visited, must has a cycle
            return true;
        visited[node-'A'] = true;
        for(int i=0;i<26;i++){
            if(graph[node-'A'][i]){
                if(isCycle((char)(i+'A'), graph, visited))
                    return true;
            }
        }
        return false;
    }

    private static String getExpressionHelper(char root, boolean[][] graph){
        String left = "", right = ""; //if no children, left and right should be empty
        for(int i=0;i<26;i++){
            if(graph[root-'A'][i]){
                left = getExpressionHelper((char)(i+'A'), graph);
                for(int j=i+1;j<26;j++){
                    if(graph[root-'A'][j]){
                        right = getExpressionHelper((char)(j+'A') ,graph);
                        break;
                    }
                }
                break;
            }
        }
        return "("+root+left+right+")";
    }


    public static void main(String... args)
    {
        System.out.println(GetSExpression("(A,B) (A,C) (B,D) (D,C)"));
    }
}
