package SmartHomeScheduling;

import java.util.ArrayList;

public class TimeInterval {
    int alpha; //Constant to calculate price
    ArrayList<PowerLevel> SingleInterval;

    TimeInterval (int a){
        alpha = a;
        SingleInterval = new ArrayList<>();
    }

    public int getAlpha(){
        return alpha;
    }

    public PowerLevel getOnePowerLevel (int index){
        if (index >= SingleInterval.size()){
            System.out.println("Something is wrong!");
        }
        return SingleInterval.get(index);
    }

    public void addPowerLevel (PowerLevel p){
        SingleInterval.add(p);
    }
}
