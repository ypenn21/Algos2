package com.yanni;

import java.util.Stack;

public class ReverseString {

    public static void main (String args[] ){
        String myStr = "This is a line.";

        for (int i = myStr.length()-1; i >= 0; i-- ){
            System.out.print(myStr.charAt(i));
        }
        System.out.println("");
        for (int i = 0; i < myStr.length(); i++ ){
            System.out.print(myStr.charAt(i));
        }
    }


}
