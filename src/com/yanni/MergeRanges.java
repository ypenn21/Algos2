package com.yanni;

import java.util.*;

public class MergeRanges {

    public static void main (String[]args){
        Interval interval1 = new Interval(1, 10);
        Interval interval2 = new Interval(8, 20);
        Interval interval3 = new Interval(21, 30);
        Interval interval4 = new Interval(40, 50);


        List<Interval> intervals = new ArrayList<>();
        intervals.add(interval1);
        intervals.add(interval2);
        intervals.add(interval3);
        intervals.add(interval4);

        List<Interval> mergedIntervals = merge(intervals);

        for( Interval interval : mergedIntervals ) {
            System.out.println(interval.start+"-"+interval.end+" ");
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();

        if(intervals==null||intervals.size()==0)
            return result;

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start!=i2.start)
                    return i1.start-i2.start;
                else
                    return i1.end-i2.end;
            }
        });

        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                Interval merged = new Interval(pre.start, Math.max(pre.end, curr.end));
                pre = merged;
            }
        }
        result.add(pre);

        return result;
    }

    // incorrect implementation
    public Map mergeRanges(List<Map.Entry<Integer, Integer>> entryList) {

        Map mergedRanges = new HashMap<Integer, Integer>();
        Map.Entry<Integer,Integer > chkEntry = null;
        for (int i =0; i < entryList.size(); i++) {
            if (chkEntry == null) {
                chkEntry = entryList.get(i);
                continue;
            }
            Map.Entry<Integer, Integer> mergeEntry = entryList.get(i);
            if (chkEntry.getKey() >= mergeEntry.getKey() && chkEntry.getValue() <= mergeEntry.getValue()) {
//                mergedRanges.remove(chkEntry.getKey());
                mergedRanges.put(mergeEntry.getKey(), mergeEntry.getValue());
                chkEntry = mergeEntry;
            } else if (chkEntry.getKey() >= mergeEntry.getKey() && chkEntry.getValue() >= mergeEntry.getValue()) {
//                mergedRanges.remove(chkEntry.getKey());
                mergedRanges.put(mergeEntry.getKey(), chkEntry.getValue());
                chkEntry = mergeEntry;
            }
//            else if(chkEntry.getKey() <= mergeEntry.getKey() && chkEntry.getValue() >= mergeEntry.getKey() && chkEntry.getValue() <= mergeEntry.getValue()) {
////                mergedRanges.remove(chkEntry.getKey());
//                mergedRanges.put(chkEntry.getKey(), mergeEntry.getValue());
//                chkEntry = mergeEntry;
//            }
            else if (chkEntry.getKey() <= mergeEntry.getKey() && chkEntry.getValue() <= mergeEntry.getValue()) {
//                mergedRanges.remove(chkEntry.getKey());
                mergedRanges.put(chkEntry.getKey(), mergeEntry.getValue());
                chkEntry = mergeEntry;
            } else if (chkEntry.getKey() <= mergeEntry.getValue() && chkEntry.getValue() >= mergeEntry.getValue()) {
//                mergedRanges.remove(chkEntry.getKey());
                mergedRanges.put(mergeEntry.getKey(), chkEntry.getValue());
                chkEntry = mergeEntry;
            } else {
                mergedRanges.put(mergeEntry.getKey(), mergeEntry.getValue());
            }
        }

        return mergedRanges;

    }
}

class Interval {

    public Integer start;
    public Integer end;

    public Interval(Integer start, Integer end){
        this.start = start;
        this.end = end;
    }
}
