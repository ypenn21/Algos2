package com.yanni;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class FindSubstrings
{

    public List findSubstringsWithKDistinctCharacters(String s, int k) {
        char[] letters = s.toCharArray();
        Set<String> subStrings = new LinkedHashSet();
        for (int i = 0, n = letters.length - k; i <= n; i++) {
            Set<Character> uniques = new LinkedHashSet<Character>();

            for (int j = i, m = i + k; j < m; j++) {
                uniques.add(letters[j]);
            }

            if (uniques.size() == k) {
                StringBuilder builder = new StringBuilder();

                for(Character character : uniques) {
                    builder.append(character);
                }
                subStrings.add(builder.toString());
            }
        }
        return new ArrayList(subStrings);
    }
    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public List<String> subStringsKDist(String inputStr, int num)
	{
        // WRITE YOUR CODE HERE
        return findSubstringsWithKDistinctCharacters(inputStr, num);
    }

    // METHOD SIGNATURE ENDS
    public static void main(String args[]){
        FindSubstrings findSubstrings = new FindSubstrings();
        System.out.println(""+findSubstrings.subStringsKDist("abcdefear", 3));

    }
}