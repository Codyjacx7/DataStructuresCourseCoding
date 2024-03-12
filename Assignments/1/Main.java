
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner fileScanner = new Scanner (new File("C:\\Users\\codyj\\DataStructuresCourseCoding\\Assignments\\DataStructuresAssignment1.txt"));
        int numShelters = fileScanner.nextInt();
        for(int i = 1; i <= numShelters; i++){
            Shelter shelter = new Shelter();
            shelter.readShelterInfo(fileScanner);
            shelter.computeMinMoney();
            shelter.printMoneyExchanged(i);
        }
    }
}
