package SmartHomeScheduling;

public class PowerLevel {
    int energyConsumed;
    int cost;

    PowerLevel (int e, int a){ //Arguments: Energy Consumed and Alpha
        energyConsumed = e;
        cost = e*a;
    }

}
