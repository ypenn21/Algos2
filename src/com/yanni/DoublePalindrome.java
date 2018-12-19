package com.yanni;

import sun.jvm.hotspot.utilities.Assert;

public class DoublePalindrome {
    public static boolean isDoublePalindrome(String string) {
        int length = string.length();
        // if length is not even, then it is not a double palindrome
        if (length % 2 != 0) {
            return false;
        }
        int start = 0;
        int end = length - 1;
        int middle = (end - start) / 2;
        while (start < middle) {
            // if characters are same, move the pointers, otherwise break and
            // return false
            if ((string.charAt(start) == string.charAt(middle))
                    && (string.charAt(start) == string.charAt(end))) {
                start++;
                middle--;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;
        while (start < end) {
            // if characters are same, move the pointers, otherwise break and
            // return false
            if (string.charAt(start) == string.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
       System.out.println (isDoublePalindrome("daddad")==true);
    }

}
