package SmartHomeScheduling;

import java.util.ArrayList;

public class EachSolution implements Comparable<EachSolution> {
    private int totalEnergy;
    private int totalCost;
    private ArrayList<PowerLevel> oneSolution = new ArrayList<>();

    public void addPowerLevel (PowerLevel p){
        oneSolution.add(p);
    }

    public int getTotalEnergy(){
        return totalEnergy;
    }

    public int getTotalCost(){
        return totalCost;
    }

    public void calculateAll (){
        int energy = 0;
        int cost = 0;
        for (PowerLevel p : oneSolution){
            energy += p.energyConsumed;
            cost += p.cost;
        }
        totalEnergy = energy;
        totalCost = cost;
    }

    @Override
    public int compareTo(EachSolution o) {
        return this.totalCost - o.totalCost;
    }
}
