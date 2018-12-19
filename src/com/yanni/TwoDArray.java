package com.yanni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDArray {

    public static List<String> AllCombinations(List<List<String>> aList) {
        if(aList.size() == 0) { return new ArrayList<String>(); }
        List<String> myFirstSubList = aList.remove(0);
        List<String> myStrings = new ArrayList<String>();
        for(String c : myFirstSubList) {
            myStrings.add(c.toString());
        }

        return AllCombinationsHelper(aList, myStrings);
    }

    public static void main(String[] args) {
        //set values for ArrayOfArrays
        List<String> VariableA = new ArrayList<String>(Arrays.asList("red", "green"));
        List<String> VariableB = new ArrayList<String>(Arrays.asList("A", "B", "C"));
        List<String> VariableC = new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));

        List<List<String>> aofA = new ArrayList<List<String>>();
        aofA.add(VariableA); aofA.add(VariableB); aofA.add(VariableC);
        System.out.println(AllCombinations(aofA));
    }

    public static List<String> AllCombinationsHelper(List<List<String>> aList,
                                                     List<String> aCollection) {
        if(aList.size() == 0) { return aCollection; }
        List<String> myFirstList = aList.remove(0);
        List<String> myReturnSet = new ArrayList<String>();

        for(String s : aCollection) {
            for(String c : myFirstList) {
                myReturnSet.add(c + s);
            }
        }

        return AllCombinationsHelper(aList, myReturnSet);
    }
}
