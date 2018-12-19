package com.yanni;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Anagrams {
    public static int numberNeeded(char[] a, char[] b) {
//        if(b.length()==end){
//            return size;
//        }
        int i = 0;
        while(i!=-1){
            if( a[i] == b[i] ){
               i++;
            } else{
                break;
            }
        }
        return (a.length-i)*2;
    }
  
    public static void main(String[] args) {
        String a = "bacdc";
        String b = "dcbad";
        //System.out.println(" "+isAnagram(a, b));
        char[] word1 = a.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = b.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        System.out.println("isAnagram:"+isAnagram(a, b));
        System.out.println(numberNeeded(word1, word2));
    }

    public static boolean isAnagram(String firstWord, String secondWord) {
        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}