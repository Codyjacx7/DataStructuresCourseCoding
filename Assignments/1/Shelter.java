
import java.util.*;
import java.util.Scanner;

public class Shelter{
    public int numPeople;
    public ArrayList<Double> expenses;
    public double minMoneyExchanged;

    public Shelter(){
        expenses = new ArrayList<>();
    }

    public void readShelterInfo(Scanner scanner){
        numPeople = scanner.nextInt();
        int i;
        for(i = 0; i < numPeople; i++){
            expenses.add(scanner.nextDouble());
        }
     }
    public static void Double(){
    }
    public void computeMinMoney(){
        double totalExpenses = expenses.stream().mapToDouble(Double -> Double).sum();
        double averageExpenses = totalExpenses / numPeople;
        for(double expense : expenses){
            double sum = 0.0;
            sum += expense;
        }
        double exchange = 0.0;
        for(double expense : expenses){
            if(expense > averageExpenses){
                exchange += expense - averageExpenses;
            }
        }
        minMoneyExchanged = exchange;
    }
    public void printMoneyExchanged(int shelterNumber){
        System.out.printf("Shelter %d amount would be: $%.2f\n", shelterNumber, minMoneyExchanged);
    }
}
