package SmartHomeScheduling;

import java.util.ArrayList;

public class TheSystem {
    int powerLevel;
    int timeInterval;
    ArrayList<TimeInterval> SchedulingQueue;

    TheSystem(int pLevel, int tInterval){
        powerLevel = pLevel;
        timeInterval = tInterval;
        SchedulingQueue = new ArrayList<>();
    }

    public TimeInterval getOneInterval (int index){
        return SchedulingQueue.get(index);
    }

    public void addTimeInterval (TimeInterval t){
        SchedulingQueue.add(t);
    }
}
