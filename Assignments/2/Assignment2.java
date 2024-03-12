package Assignments;
import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Assignment2 {
    public void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] arrayInput = new int [6];
        for (int i = 0; i < arrayInput.length; i++){
            System.out.println("Enter an integer: ");
            arrayInput [i] = scanner.nextInt();
        }
            System.out.println("Input Array: " + Arrays.toString(arrayInput));
            scanner.close();
            sum(arrayInput);
            equal(sumLeft, sumRight);
    }


    public static void sum(int [] arrayInput){   //THIS NEEDS TO BE CHANGED TO RECURSIVE
        int sumLeft = 0;
        int sumRight = 0;
        for (int i = 0; i < arrayInput.length; i++){
            if ( i < arrayInput.length / 2){
                sumLeft += arrayInput[i];
            }
            else {
                sumRight += arrayInput[i];
            }
        }
        System.out.println("Left Sum: " + sumLeft);
        System.out.println("Right Sum: " + sumRight);
    }

    public static void equal(int sumLeft, int sumRight){
        if (sumLeft == sumRight){
            System.out.println("The halves are equal to eachother");
        }
        else{
            System.out.println("The halves are not equal to eachother");
        }
    }
}
    

