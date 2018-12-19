package com.yanni;

import java.util.HashMap;
import java.util.Map;

public class GetDistinctPairsGivenSum {

    public static void main(String args[])
    {
        int[] arr = { 1, 5, 7, -1, 5, 1 };
        int sum = 6;
        getPairsCount(arr, sum);
    }

    // Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static void getPairsCount(int[] arr, int sum)
    {
        Map myMap = new HashMap();

        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum) {
                    myMap.put(arr[i], arr[j]);
                    myMap.put(arr[j], arr[i]);
                }

        System.out.printf("Count of pairs is %d", myMap.size()/2);
    }



}
