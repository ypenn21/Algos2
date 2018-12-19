package com.yanni;

import java.util.*;

//Write your code here
public class Parser{
    public boolean checkParenthesesBalance(String str){
        List<List<Integer>> table = new ArrayList<List<Integer>>();

        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ( ch == '(' || ch == '{') {
                stack.push(ch);
            } else if (( ch == '}' || ch == ')')
                    && (!stack.isEmpty())) {
                if (((char) stack.peek() == '(' && ch == ')')
                        || ((char) stack.peek() == '{' && ch == '}')) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                if (( ch == '}' || ch == ')')) {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;

    }

    public static void main (String args[])
    {
//        PriorityQueue<String> pq = new PriorityQueue<String>();
//        pq.add("2");
//        pq.add("4");
//        System.out.print(pq.peek()+" ");
//        pq.offer("1");
//        pq.add("3");
//        pq.remove("1");
//        System.out.print(pq.poll()+" ");
//        if(pq.remove("2")){
//            System.out.print(pq.poll()+" ");
//        }
//        String hi = pq.poll()+" "+pq.peek();
//        System.out.print(hi);
//        Calendar cal = Calendar.getInstance();
//        int i =7/0;
        String revert = "revert this string bra!!";
        System.out.println(revert.hashCode());
//        Object [] bucket = new Object[];
        char[] characters = revert.toCharArray();
        StringBuffer buffer = new StringBuffer();
        for(int index = characters.length-1; index>=0; index--){
            buffer.append(characters[index]);
        }
        System.out.println(buffer.toString());
    }
}

class Children extends Parser {

}