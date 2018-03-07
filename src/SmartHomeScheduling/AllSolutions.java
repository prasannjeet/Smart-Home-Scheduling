package SmartHomeScheduling;

import java.util.*;

public class AllSolutions {
    HashMap<Integer, ArrayList<EachSolution>> allSolutions = new HashMap<>();

    AllSolutions (TheSystem S){
        int powerLevel = S.powerLevel;
        int timeInterval = S.timeInterval;
        int totalSolutions=(int) Math.pow((double)powerLevel, (double)timeInterval);
        int[][] helperArray = new int[totalSolutions][timeInterval];

        for (int j=0; j<timeInterval; j++){
            for (int k=0; k<totalSolutions; k++){
                int incrementFactor = (int) Math.pow((double)powerLevel,(double)j);
                int intermediate = k/incrementFactor;
                int finalValue = intermediate%powerLevel;
                helperArray[k][j] = finalValue;
            }
        }

        for (int i=0; i<totalSolutions; i++){
            EachSolution tempSolution = new EachSolution();
            for (int j=0; j<timeInterval; j++){
                PowerLevel item = S.getOneInterval(j).getOnePowerLevel(helperArray[i][j]);
                tempSolution.addPowerLevel(item);
            }
            tempSolution.calculateAll();
            this.addOneSolution(tempSolution);
        }
    }

    public void addOneSolution (EachSolution es){
        if (allSolutions.containsKey(es.getTotalEnergy())){
            allSolutions.get(es.getTotalEnergy()).add(es);
        }
        else {
            ArrayList<EachSolution> tempList = new ArrayList<>();
            tempList.add(es);
            allSolutions.put(es.getTotalEnergy(), tempList);
        }
    }

    public void sortAll(){
        Set<Integer> allKeys = allSolutions.keySet();
        for (Integer x : allKeys){
            Collections.sort(allSolutions.get(x));
        }
    }

    public ArrayList<EachSolution> finalSolution (){
        this.sortAll();
        ArrayList<EachSolution> returnList = new ArrayList<>();
        Set<Integer> keys = allSolutions.keySet();
        for (Integer perEnergy : keys){
            returnList.add(allSolutions.get(perEnergy).get(0));
        }
        return returnList;
    }
}
