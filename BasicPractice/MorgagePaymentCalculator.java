package BasicPractice;
import java.text.NumberFormat;
import java.util.Scanner;
public class MorgagePaymentCalculator {
    public static void main(String[] args){
            //Collect data
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the total dollar amount of the principle? ");
        float loanPrinciple = scanner.nextFloat();
        System.out.print("What is the loan term in months? ");
        float loanTerm = scanner.nextInt();
        System.out.print("What is the annual percentage interest rate on the loan? ");
        float loanRate = scanner.nextFloat();
        scanner.close();
            //Use data collected to calculate monthly payment
        float decimalLoanRate = loanRate / 100;
        float interestTotal = decimalLoanRate * loanPrinciple;
        float morgageTotal = interestTotal + loanPrinciple;
        float morgagePayment = morgageTotal / loanTerm;
            //Print morgage payment
        System.out.println("Your monthly morgage payment is " + morgagePayment);
    }
    public static void YoutubeSolution() { 
            final byte MONTHS_IN_YEAR = 12;
            final byte PERCENT = 100;

            Scanner scanner = new Scanner(System.in);

            System.out.print("Principle: ");
            int principle = scanner.nextInt();

            System.out.println("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

            System.out.println("Period (Years): ");
            byte years = scanner.nextByte();
            int numberOfPayments = years * MONTHS_IN_YEAR;

            double morgage = principle
                        * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                        / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);
            String morgageFormatted = NumberFormat.getCurrencyInstance().format(morgage);
            System.out.println("Mortgage: " + morgageFormatted);
            scanner.close();
        }
    }
