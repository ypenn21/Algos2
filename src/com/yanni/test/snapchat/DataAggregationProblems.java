package com.yanni.test.snapchat;// # // Given a newline delimited JSON file giving total count of users
// # //   by country, device, and age
  
// # //   Write methods to compute aggregations on these keys.
// # //   Ensure the program runs and outputs the answer.
// # //   Consider how to set this up so values for attributes are not hardcoded, but can be adjusted based on user preference.
  
// # //   1. Country with most different ages, and how many
// # //   2. highest total count of user age by: 
// # //      a. country
// # //      b. device
// # //      c. country + device

// # //   {"country":"AU","device":"iOS","age":"20","total_count":"328953"}
// # //   {"country":"AU","device":"Android","age":"20","total_count":"201728"}
// # //   {"country":"AU","device":"Android","age":"26","total_count":"423756"}
// # //   {"country":"US","device":"iOS","age":"29","total_count":"4525"}
// # //   {"country":"US","device":"iOS","age":"35","total_count":"79613"}
// # //   {"country":"US","device":"Android","age":"32","total_count":"425374"}
// # //   {"country":"GB","device":"iOS","age":"43","total_count":"284796"}
// # //   {"country":"GB","device":"iOS","age":"27","total_count":"720529"}

// # //   In the above, this should get you: 
// # //   1. US, with 3 distinct ages, 29, 35, 32
  
// # //   2a. by country: AU -> age 20; US -> age 32; GB -> age 27
  
// # //   2b. by device: iOS -> age 27, Android -> age 32
  
// # //   by country and device: 
// # //     AU + iOS -> age 20,
// # //     AU + Android -> age 26,
// # //     US + iOS -> age 35
// # //     ...
import java.util.*;

class Row {
    public Row() {
        
    }
    
    public Row(String country, String device, String age, Integer total) {
        this.country = country;
        this.device = device;
        this.age = age;
        this.total = total;
    }
    String country;
    String device;
    String age;
    Integer total=0;
    
}

// class Result {
    
//     public Row(String country, String device, String age, String total) {
//         this.country = country;
//         this.device = device;
//         this.age = age;
//         this.total = total;
//     }
//     String country;
//     Integer age;
//     String age;
//     Integer total;
    
// }

public class DataAggregationProblems {
    static final String COUNTRY = "country";
    static final String DEVICE = "device";
    static final String AGE = "age";
    static final String TOTAL = "total";

    
    // # //   {"country":"AU","device":"iOS","age":"20","total_count":"328953"}
// # //   {"country":"AU","device":"Android","age":"20","total_count":"201728"}
// # //   {"country":"AU","device":"Android","age":"26","total_count":"423756"}
// # //   {"country":"US","device":"iOS","age":"29","total_count":"4525"}
    
    public static void main(String args[] ) throws Exception {
        List<Row> rows = new ArrayList();
       rows.add(new Row("AU", "iOS", "20", 328953));
       rows.add(new Row("AU", "Android", "20", 201728));
       rows.add(new Row("AU", "Android", "26", 423756));
       rows.add(new Row("US", "iOS", "29", 4525));
        
        rows.add(new Row("US", "iOS", "35", 79613));
        rows.add(new Row("US", "Android", "32", 425374));
        rows.add(new Row("GB", "iOS", "43", 284796));
        rows.add(new Row("GB", "iOS", "27", 729529));
        Map<String, Set<Integer>> resultSet = getMostVariationAgePerCountry( rows );
        // for (  String key : resultSet.keySet()) 
        //     System.out.println(key+" "+resultSet.get(key));
        resultSet = getMostAgeDemo(rows );
        for (  String key : resultSet.keySet())  {
            Row row = (Row)resultSet.get(key);
            System.out.println(key+" "+row.age +" "+row.total );
        }
        // System.out.println(getMaxVariation (resultSet));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
    
    public static String getMaxVariation (Map<String, Set<Integer>> resultSet) {
        String maxCountry=null;
        Integer count = 0;
        for (  String key : resultSet.keySet()) {
            Set numbers = ((HashSet) resultSet.get(key));
            if(maxCountry == null) {
                maxCountry = key;
                count = numbers.size();
            } else if (count < numbers.size()) {
                maxCountry = key;
                count = numbers.size();
            }
            System.out.println(key+" "+resultSet.get(key));
        }
        return maxCountry;
        
    }
    
    public static Map getMostAgeDemo(List<Row> rows ) {
        Map<String, Row> countryNVariation = new HashMap();
        for (Row row : rows) {
            Row rowTemp = countryNVariation.get(row.country);
            // if(rowTemp == null) {
                rowTemp = new Row();
                rowTemp.age = row.age;
                rowTemp.total += row.total;
                countryNVariation.put(row.country, rowTemp);
            // }else {
            //     countryNVariation.put(row.country, rowTemp);
            // }
        }
        return countryNVariation;
        
    }
    
    public static Map getMostVariationAgePerCountry(List<Row> rows ) {
        Map<String, Set<String>> countryNVariation = new HashMap();
        for (Row row : rows) {
            Set<String> ages = countryNVariation.get(row.country);
            if(ages == null) {
                ages = new HashSet();
                ages.add(row.age);
                countryNVariation.put(row.country, ages);
            }else {
                ages.add(row.age);
                countryNVariation.put(row.country, ages);
            }
        }
        return countryNVariation;
        
    }
    
}