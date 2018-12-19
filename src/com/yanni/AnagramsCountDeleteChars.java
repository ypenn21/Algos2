package com.yanni;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class AnagramsCountDeleteChars {
    static int remAnagram(String str1, String str2)
    {
        // make hash array for both string 
        // and calculate frequency of each
        // character
        int count1[] = new int[26]; 
        int count2[] = new int[26];
 
        // count frequency of each charcter 
        // in first string
        countLetters(str1, count1);
     
        // count frequency of each charcter 
        // in second string
        countLetters(str2, count2);
 
        // traverse count arrays to find 
        // number of charcters to be removed
        int result = 0;
        for (int i = 0; i < 26; i++)
            result += Math.abs(count1[i] -
                               count2[i]);
        return result;
    }

    private static void countLetters(String str, int count[]){
        for (int i = 0; i < str.length() ; i++) {
            char aOrA = 'a';
            if(Character.isUpperCase(str.charAt(i)))
                aOrA = 'A';
//            System.out.println(aOrA+0);
            count[str.charAt(i) - aOrA]++;
        }
    }
  
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        String a = "BbAacdc";
        String b = "dcbad";
        System.out.println(remAnagram(a,b));
    }
}
