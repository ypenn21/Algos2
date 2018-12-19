package com.yanni;

import java.util.ArrayList;
import java.util.List;

public class Fibonacci {

    private static List<Integer> fibNthNumber;

    static {
        fibNthNumber = new ArrayList<>(100);
        fibNthNumber.add(0);
        fibNthNumber.add(1);
        for (int i =1; i<99;i++){
            fibNthNumber.add(-1);
        }
    }

    public Fibonacci(){
    }

    static int fib2(int n)
    {
        Integer neg = -1;
        if (n <= 1)
            return n;
        if(fibNthNumber.get(n-1) != neg || fibNthNumber.get(n-2) != neg) {
            fibNthNumber.set(n, (fibNthNumber.get(n-1)+fibNthNumber.get(n-2)));
        } else if ( fibNthNumber.get(n) == neg ){
            for(int i=2; i<=n ;i++){
                fibNthNumber.set(i, (fibNthNumber.get(i-1)+fibNthNumber.get(i-2)));

            }
        }

        return fibNthNumber.get(n);
    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    public static void main (String args[])
    {
        int n = 9;
        for(int i=0; i<n; i++)
            System.out.println(fib2(i));
    }
}
