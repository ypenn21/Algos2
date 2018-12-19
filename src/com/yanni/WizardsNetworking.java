package com.yanni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class WizardsNetworking {

    public static void main(String[] arguments) {
        List wizards = Arrays.asList(new String[] {
                "1 2 3",
                "8 6 4",
                "7 8 3",
                "8 1",
                "6",
                "8 7",
                "9 4",
                "4 6",
                "1",
                "1 4"
        });

        List<Integer> shortestPathToTargetWizard = meet(wizards);
        System.out.println(shortestPathToTargetWizard);
//        printIntArray(shortestPathToTargetWizard);
    }

    // need pathToN which is the return values, shortestDistance keep state of shortestDistance between current connection and start, keep state of wizardsVisted, and another list of wizards toBeProcessed
    private static List<Integer> meet(List wizards) {
        //all the data structures needed
        List<Integer> pathToN = new ArrayList();
        List<Integer> shortestDistance = new ArrayList<>();
        Set<Integer> wizardsVisted = new HashSet();
        List<Integer> toBeProcessed = new ArrayList<>();
        IntStream.range(0, wizards.size()).forEach(i ->{
                shortestDistance.add(Integer.MAX_VALUE);
                pathToN.add(Integer.MAX_VALUE);
            }
        );
        //set the starting point
        shortestDistance.set(0,0);
        pathToN.set(0,0);
        toBeProcessed.add(0);

        //algo here before all setup
        Integer currentWiz = findMinDistanceWizardToProcess(toBeProcessed, shortestDistance, wizardsVisted);
        while(currentWiz != wizards.size()-1 && wizardsVisted.size()<wizards.size()) {
            wizardsVisted.add(currentWiz);
            String wizard = (String) wizards.get(currentWiz);
            String[] wizardNetwork = wizard.split(" ");
            for(String connection : wizardNetwork){
                int wizConnect = Integer.parseInt(connection);
                if( currentWiz < wizConnect)
                    toBeProcessed.add(wizConnect);
            }

            for(int wizard2Process : toBeProcessed) {
                int distanceBetweenWizards = shortestDistance.get(currentWiz)+1; //weight of each edge can be changed here either 1 or whatever
                if(shortestDistance.get(wizard2Process) >  distanceBetweenWizards){
                    shortestDistance.set(wizard2Process, distanceBetweenWizards);
                    pathToN.set(wizard2Process, currentWiz);
                }

            }
            currentWiz = findMinDistanceWizardToProcess(toBeProcessed, shortestDistance, wizardsVisted);
        }

        return pathToN;
    }


    private static List<Integer> meet2(List wizards, int target) {
        //all the data structures needed
        List<Integer> pathToN = new ArrayList();
        List<Integer> shortestDistance = new ArrayList<>();
        Set<Integer> wizardsVisted = new HashSet();
        List<Integer> toBeProcessed = new ArrayList<>();
        IntStream.range(0, wizards.size()).forEach(i -> {
                    shortestDistance.add(Integer.MAX_VALUE);
                    pathToN.add(Integer.MAX_VALUE);
                }
        );

        pathToN.set(0, 0);
        shortestDistance.set(0,0);
        toBeProcessed.add(0);
        int currentWizard = findMinDistanceWizardToProcess(toBeProcessed, shortestDistance, wizardsVisted);
        while(currentWizard!=target && wizardsVisted.size() < wizardsVisted.size()) {
            wizardsVisted.add(currentWizard);
            String[] wizConnectStr = ((String) wizards.get(currentWizard)).split(",");
            for(String wizardConnect : wizConnectStr) {
                if(currentWizard < Integer.parseInt(wizardConnect))
                    toBeProcessed.add(Integer.parseInt(wizardConnect));
            }

            for(Integer wizToProces : toBeProcessed){
                int distanceBetweenWiz = shortestDistance.get(currentWizard)+1;
                if( shortestDistance.get(wizToProces) < distanceBetweenWiz){
                    shortestDistance.set(wizToProces, distanceBetweenWiz);
                    pathToN.set(wizToProces, currentWizard);
                }

            }

            findMinDistanceWizardToProcess(toBeProcessed, shortestDistance, wizardsVisted);

        }

        return shortestDistance;
    }

    // remove toBeProcessed as each int gets processed.
    private static int findMinDistanceWizardToProcess(List<Integer> toBeProcessed, List<Integer> shortestDistance, Set<Integer> wizardsVisted){
        Integer minDisWiz =-1;

        for(int i=0;i<toBeProcessed.size();i++){
            Integer currentWizard = toBeProcessed.get(i);
            if(!wizardsVisted.contains(currentWizard)
                    && shortestDistance.get(currentWizard) < Integer.MAX_VALUE ){
                minDisWiz = toBeProcessed.get(i);
                break;
            }
        }
        toBeProcessed.remove(minDisWiz);
        return minDisWiz;

    }
}