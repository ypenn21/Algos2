package com.yanni;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {

//    public static boolean isBalanced(String expression) {
//        char[] check = expression.toCharArray();
//        Map<Character, Integer> characterCount = new HashMap<>();
//        if(check.length%2 != 0 ){
//            return false;
//        }
//        for(int i=0; i < check.length;i++){
//            if(!isOpen(check[i])){
//                Integer closedCount = characterCount.get(getOpen(check[i]));
//                Integer openCount = characterCount.get(check[i]);
//                if(closedCount == null){
//                    closedCount=0;
//                } else{
//                    closedCount++;
//                    if(closedCount>openCount){
//                        return false;
//                    }
//                }
//                characterCount.put(check[i], closedCount);
//            } else {
//                Integer count = characterCount.get(check[i]);
//                if(count == null){
//                    count=0;
//                } else{
//                    count++;
//                }
//                characterCount.put(check[i], count);
//            }
//        }

//        for(int i=0; i < (check.length/2) ;i++){
//            Character open = check[i];
//            Character close = stack.pop();
//            if(!isMatching( open.toString(), close.toString() )){
//                return false;
//            }
//        }

//
//        return true;
//    }

//    public static boolean isBalanced(String expression) {
//        char[] check = expression.toCharArray();
//        Stack<Character> stack = new Stack<Character>();
//        if(check.length%2 != 0 ){
//            return false;
//        }
//        for(int i=0; i < check.length;i++){
//            String chk = ((Character) check[i]).toString();
//            if(isOpen(chk)){
//                stack.push(check[i]);
//            } else {
//                Character open = stack.pop();
//                if(!isMatching( open.toString(), chk )){
//                    return false;
//                }
//            }
//        }
//
//        return true;
//    }

    /* Returns true if character1 and character2
are matching left and right Parenthesis */
    static boolean isMatchingPair(char character1, char character2) {
        if (character1 == '(' && character2 == ')')
            return true;
        else if (character1 == '{' && character2 == '}')
            return true;
        else if (character1 == '[' && character2 == ']')
            return true;
        else
            return false;
    }

    public static boolean isOpen(char open) {
        boolean isMatch = false;
        if (open == '{') {
            isMatch = true;
        } else if (open == '[') {
            isMatch = true;
        } else if (open == '(') {
            isMatch = true;
        }
        return isMatch;

    }

    /* Return true if expression has balanced
       Parenthesis */
    static boolean areParenthesisBalanced(char exp[]) {
        /* Declare an empty character stack */
        Stack<Character> st = new Stack<Character>();

       /* Traverse the given expression to
          check matching parenthesis */
        for (int i = 0; i < exp.length; i++) {

          /*If the exp[i] is a starting
            parenthesis then push it*/
            if (isOpen(exp[i]))
                st.push(exp[i]);

          /* If exp[i] is an ending parenthesis
             then pop from stack and check if the
             popped parenthesis is a matching pair*/
            if (!isOpen(exp[i])) {

              /* If we see an ending parenthesis without
                 a pair then return false*/
                if (st.isEmpty()) {
                    return false;
                }

             /* Pop the top element from stack, if
                it is not a pair parenthesis of character
                then there is a mismatch. This happens for
                expressions like {(}) */
                else if (!isMatchingPair(st.pop(), exp[i])) {
//                    st.peek();
                    return false;
                }
            }

        }
               /* If there is something left in expression
          then there is a starting parenthesis without
          a closing parenthesis */

        if (st.isEmpty())
            return true; /*balanced*/
        else
        {   /*not balanced*/
            return false;
        }
    }

//    public static boolean isOpen(Character open) {
//        boolean isMatch = false;
//        if(open.equals("{")){
//            isMatch = true;
//        } else if(open.equals("[")){
//            isMatch = true;
//        } else if(open.equals("(")){
//            isMatch = true;
//        }
//        return isMatch;
//
//    }

        public static String getOpen (Character closed){
            String open = null;
            if (closed.equals("}")) {
                open = "{";
            } else if (closed.equals("]")) {
                open = "[";
            } else if (closed.equals(")")) {
                open = "(";
            }
            return open;

        }

        public static boolean isMatching (String open, String close){
            boolean isMatch = false;
            if (open.equals("{")) {
                isMatch = close.equals("}");
            } else if (open.equals("[")) {
                isMatch = close.equals("]");
            } else if (open.equals("(")) {
                isMatch = close.equals(")");
            }
            return isMatch;

        }

        public static void main (String[]args){
//        Scanner in = new Scanner(System.in);
//        int t = in.nextInt();
//        for (int a0 = 0; a0 < t; a0++) {
//            String expression = in.next();
            String expression = "{[(])}";
            System.out.println((areParenthesisBalanced(expression.toCharArray())) ? "YES" : "NO");
//        }
        }
}