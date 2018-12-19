package com.yanni;

import java.util.*;
 
class Palindrome
{
   public static void main(String args[])
   {
      String original, reverse = ""; // Objects of String class
      Scanner in = new Scanner(System.in);
 
      System.out.println("Enter a string to check if it is a palindrome");
      original = in.nextLine();
 
      int length = original.length();
      int[] array = {1,2,3,4,5,6};

//      for (int i = array.length-1; i>=0; i--){
//         System.out.println(array[i]);
//
//      }
//
      for (int i = 0; original.length()-i>0; i++){
         System.out.println(original.charAt(i));

      }
 
//      for ( int i = length - 1; i >= 0; i-- )
//         reverse = reverse + original.charAt(i);
      StringBuffer buffer = new StringBuffer(reverse);

      for (int i = original.length()-1; i>=0; i--)
         buffer.append(original.charAt(i));


      if (original.equals(buffer.toString()))
         System.out.println("Entered string is a palindrome.");
      else
         System.out.println("Entered string isn't a palindrome.");
 
   }
}