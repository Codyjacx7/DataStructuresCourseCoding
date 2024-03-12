package BasicPractice;
import java.util.Scanner;

public class ReadingInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is your age? ");
        String age = scanner.nextLine().trim();
        System.out.print("What is your name? ");
        String name = scanner.nextLine().trim();
        System.out.println("Your age is " + age);
        System.out.println("Your name is " + name);
        scanner.close();
    }
    
}
