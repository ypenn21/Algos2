package com.yanni.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class UnitTest {

    @Test
    public void testMaxDays() {
        int[] one = {1, 2, 3};
        int[] two = {5,1,2,6};
        int[] three = {1,1,5,6,20,2};

        System.out.println("max days is:"+findMaxDays(three, 0));
        System.out.println("max days is:"+findMaxDays(three));
    }

    @Test
    public void insertionSort() {
        int[] array = {1,1,5,6,20,2};

        for(int i=1; i<array.length; i++) {

            int current = array[i];
            int beforeCurrent = i-1;
            while(beforeCurrent >= 0 && current < array[beforeCurrent]){
                array[beforeCurrent+1] = array[beforeCurrent];
                beforeCurrent--;
            }
            beforeCurrent++;
            array[beforeCurrent] = current;
        }
        System.out.println(""+array);
        IntStream.range(0, array.length).forEach(index -> {
                System.out.print(array[index]+" ");
        });
    }

    @Test
    public void passByValueNotReference(){
        int num1 = 1;
        int num2 = 2;
        swapThemByVal(num1, num2);
        System.out.println("num1 is:"+num1);
        System.out.println("num2 is:"+num2);
    }

    private void swapThemByVal(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("num1 is:"+num1);
        System.out.println("num2 is:"+num2);
    }

    @Test
    public void minCoins()
    {
        int coins[] =  {9, 6, 5, 1};
        int m = coins.length;
        int V = 100;
        System.out.println("Minimum coins required is "+ getAllMinCoinsCombo(coins, m, V) );
        System.out.println("Minimum coins required is "+ minCoins2(coins, m, V) );
    }

    public int minCoins(int coins[], int m, int value)
    {
        // base case
        if (value == 0) return 0;

        // Initialize result
        int res = Integer.MAX_VALUE;

        // Try every coin that has smaller value than V
        for (int i=0; i<m; i++)
        {
            if (coins[i] <= value)
            {
                int sub_res = minCoins(coins, m, value-coins[i]);

                // Check for INT_MAX to avoid overflow and see if
                // result can minimized
                if (sub_res != Integer.MAX_VALUE && sub_res + 1 < res) {
//                    System.out.println(coins[i]);
                    res = sub_res + 1;
                }
            }
        }
        return res;
    }

    // m is size of coins array (number of different coins)
    int minCoins2(int coins[], int numberCoins, int V)
    {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int table[] = new int[V+1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i=1; i<=V; i++)
            table[i] = Integer.MAX_VALUE;
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i=1; i<=V; i++)
        {
            List<Integer> combo = new ArrayList();
            // Go through all coins smaller than i
            for (int j=0; j<numberCoins; j++) {
                if (coins[j] <= i) {
                    int sub_res = table[i - coins[j]];
                    combo.add(coins[j]);
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i]) {
                        table[i] = sub_res + 1;
                    }
                }
            }
        }
        return table[V];
    }

    List<List<Integer>> getAllMinCoinsCombo(int coins[], int numberCoins, int V)
    {
        // table[i] will be storing the minimum number of coins
        // required for i value.  So table[V] will have result
        int table[] = new int[V+1];

        // Base case (If given value V is 0)
        table[0] = 0;

        // Initialize all table values as Infinite
        for (int i=1; i<=V; i++)
            table[i] = Integer.MAX_VALUE;

        List<List<Integer>> combos = new ArrayList();
        combos.add(new ArrayList<>());
        // Compute minimum coins required for all
        // values from 1 to V
        for (int i=1; i<=V; i++)
        {
            List<Integer> combo = new ArrayList();
            // Go through all coins smaller than i
            // another array to keep track of different previousCombos
            List<List<Integer>> previousCombos = new ArrayList();
            for (int j=0; j<numberCoins; j++) {
                if (coins[j] <= i) {
                    List<Integer> previousCombo = combos.isEmpty()?new ArrayList<>() : combos.get((i- coins[j]));
                    previousCombos.add(previousCombo);
                }
            }
            List<Integer> smallestSize = previousCombos.stream().min(Comparator.comparing(List::size)).get();
            int sum = smallestSize.stream().mapToInt(Integer::intValue).sum();
            combo.addAll(smallestSize);
            combo.add(i-sum);
            combos.add(combo);
        }
        return combos;
    }

    List differentCombo = new ArrayList<>();

    private int findMaxDays(int[] daysArr) {
        int[] maxDaysUntilPos = new int[daysArr.length ];
        maxDaysUntilPos[0] = 0;
        maxDaysUntilPos[1] = daysArr[0];

        for (int i = 2; i < maxDaysUntilPos.length; i++) {
            maxDaysUntilPos[i] = Math.max(maxDaysUntilPos[i-1], maxDaysUntilPos[i-2] + daysArr[i-1]);
        }

        return maxDaysUntilPos[maxDaysUntilPos.length - 1];
    }

    public static int findMaxDays(int[] days, int i) {
        if(i == days.length-1) {
            return days[days.length-1];
        }
        if(i > days.length -1) {
            return 0;
        }

        return Math.max(days[i] + findMaxDays(days, i+2), days[i] + findMaxDays(days, i+3));
    }
}
