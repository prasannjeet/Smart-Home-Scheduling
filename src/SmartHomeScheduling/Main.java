package SmartHomeScheduling;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Welcome to Smart Home Dynamic Programming Based Scheduling Algorithm\n\n" +
                "We need following data from you:\n" +
                "\t1.\tTotal Power Levels\n" +
                "\t2.\tTotal Time Intervals\n" +
                "\t3.\tBased on the above data, value of Alpha (The factor used to multiply energy consumption to " +
                "find out total cost) at each time interval\n" +
                "\t4.\tBased on the above data, energy consumption at each power level\n\n" +
                "=================================================================================\n" +
                "Please enter the total Power Levels in the system:\t");

        int powerLevel;
        Scanner scan = new Scanner(System.in);
        powerLevel = scan.nextInt();

        int timeInterval;
        System.out.print("Now enter the total Time Intervals in the system:\t");
        timeInterval = scan.nextInt();

        System.out.print("\nNow we will enter the value of alpha for each time interval:\n" +
                "=================================================================================\n");

        TheSystem newSystem = new TheSystem(powerLevel, timeInterval);

        for (int i=0; i<timeInterval; i++){
            System.out.print("Enter the value of alpha for time interval ["+(i+1)+"]\t");
            TimeInterval tempTimeInterval = new TimeInterval(scan.nextInt());
            newSystem.addTimeInterval(tempTimeInterval);
        }

        System.out.print("\nNow we will enter the value of energy consumption for each power level:\n" +
                "=================================================================================\n");
        ArrayList<Integer> commonPowerLevels = new ArrayList<>();

        for (int i=0; i<powerLevel; i++){
            System.out.print("Enter the Energy Consumption for power level ["+(i+1)+"]\t");
            commonPowerLevels.add(scan.nextInt());
        }

        for (int i=0; i<timeInterval; i++){
            for (int j=0; j<powerLevel; j++){
                PowerLevel tempPowerLevel = new PowerLevel(commonPowerLevels.get(j), newSystem.getOneInterval(i).getAlpha());
                newSystem.getOneInterval(i).addPowerLevel(tempPowerLevel);
            }
        }

        AllSolutions processingSolutions = new AllSolutions(newSystem);
        ArrayList<EachSolution> finalSolution = processingSolutions.finalSolution();
        System.out.print("\n=================================================================================" +
                "\nThe Solution Is:\n");
        for (EachSolution finalAnswer : finalSolution){
            System.out.println("("+finalAnswer.getTotalEnergy()+", "+finalAnswer.getTotalCost()+")");
        }
    }
}
