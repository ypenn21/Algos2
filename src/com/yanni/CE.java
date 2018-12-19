package com.yanni;

import java.util.*;
import java.util.stream.IntStream;

public class CE {


        // Implement your solution below.
    public static Character nonRepeating(String s) {

        char[] chars = s.toCharArray();
        Character noDup = chars[0];
        Map<Character, Integer> myMap = new LinkedHashMap<>();
        for(int i =0; i<chars.length;i++ ) {
            Character element = new Character(chars[i]);
            Integer charCount = myMap.getOrDefault(element, 0);
            charCount++;
            myMap.put(element, charCount);
        }

        Optional<Map.Entry<Character, Integer>> result = myMap.entrySet().stream().filter(entry -> entry.getValue()==1).findFirst();

        return result.isPresent()?result.get().getKey():null;
    }
//clock wise
//    static int[][] RotateMatrix(int[][] matrix, int n) {
//        int[][] ret = new int[n][n];
//
//        for (int i = 0; i < n; ++i) {
//            for (int j = 0; j < n; ++j) {
//                int row = n - j - 1;
//                ret[i][j] = matrix[row][i];
//            }
//        }
//
//        return ret;
//    }

    //counter clock wise
    static int[][] RotateMatrix(int[][] matrix, int n) {
        int[][] ret = new int[n][n];

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret[i][j] = matrix[j][n-i-1];
            }
        }

        return ret;
    }


    public static void main(String[] args) {

        int[][] array =  {
            { 1,2,3,4 },
            { 5,6,7,8 },
            { 9,0,1,2 },
            { 3,4,5,6 }
        };
        System.out.println("testing mod:"+-1%4);
        int[][] rotated = RotateMatrix(array, 4);
        System.out.println(rotated);

        // NOTE: The following input values are used for testing your solution.
//        System.out.println("testing mod operator: "+7 % 7);
//        int[] array1A = {1, 3, 4, 6, 7, 9};
//        int[] array2A = {1, 2, 4, 5, 9, 10};
//        System.out.println(commonElements(array1A, array2A));
        // commonElements(array1A, array2A) should return [1, 4, 9] (an array).

//        int[] array1B = {1, 2, 9, 10, 11, 12};
//        int[] array2B = {0, 1, 2, 3, 4, 5, 8, 9, 10, 12, 14, 15};
//        System.out.println(commonElements(array1B, array2B).toString());
        // commonElements(array1B, array2B) should return [1, 2, 9, 10, 12] (an array).

//        int[] array1C = {0, 1, 2, 3, 4, 5};
//        int[] array2C = {6, 7, 8, 9, 10, 11};
//        System.out.println(commonElements(array1C, array2C));
        // common_elements(array1C, array2C) should return [] (an empty array).
//        nonRepeating("abcab"); // should return 'c'
//        nonRepeating("abab"); // should return null
//        nonRepeating("aabbbc"); // should return 'c'
//        nonRepeating("aabbdbc"); // should return 'd'
    }

    // Implement your solution below.
    // NOTE: Remember to return an Integer array, not an int array.
    public static Integer[] commonElements(int[] array1, int[] array2) {
//        if(array1.length > array2.length)
            return findCommonElements(array1, array2);
//        else
//            return findCommonElements(array2, array1);

    }

    private static Integer[] findCommonElements(int[] array1, int[] array2) {
        Map<Integer, Integer> myMap = new HashMap();
        for (int i=0;i<array1.length;i++){
            Integer itemFromList = new Integer(array1[i]);
            Integer element = myMap.get(itemFromList);
            myMap.put(itemFromList, element==null?0:element+1);
        }
        List<Integer> result = new ArrayList();
        for (int i2=0;i2<array2.length;i2++){
            Integer itemFromList = new Integer(array2[i2]);
            if(myMap.get(itemFromList)!=null)
                result.add(itemFromList);
        }
        Integer[] commonElements = new Integer[result.size()];
        commonElements = result.toArray(commonElements);
        return commonElements;
    }
}