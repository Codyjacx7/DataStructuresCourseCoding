package Assignments;
import java.util.Scanner;
//import java.lang.UnsupportedOperationException;
public class Assign2 {
	public static void main(String[] args) {
		System.out.println("Enter the number of items to read: ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arrayInput = new int[n];
		//if(n % 2 == 1){exit();}
		System.out.println("Enter the numbers:");
		for(int i=0; i<n; i++) {
			arrayInput[i] = scanner.nextInt();
			}
		scanner.close();
		callRecursives(arrayInput, n);
		}

	//private static void exit() {throw new UnsupportedOperationException("Enter an even number of items to read");}

	public static void callRecursives(int[] arrayInput, int n) {
		int firstHalfSum = calculateSum(arrayInput, 0, n / 2-1);
		int secondHalfSum = calculateSum(arrayInput, n/2, n-1);
		int[] firstHalf = new int[n/2];
		System.arraycopy(arrayInput, 0, firstHalf, 0, n/2);
		int[] secondHalf = new int[n/2];
		System.arraycopy(arrayInput, n/2, secondHalf, 0, n/2);
		if(firstHalfSum == secondHalfSum) {
			System.out.println("Each half of the array sums to " + firstHalfSum);
			int f3 = exactNumbersCheck(firstHalf, secondHalf, n/2, n/2,0);
			if(f3 == firstHalf.length) {
				System.out.println("The two halves contain the same numbers.");
				int f4 = mirrorCheck(firstHalf, secondHalf, n/2, n/2,0);
				if(f4 == firstHalf.length) {
					System.out.println("The two halves are mirror images of each other.");
				}
				else {
					System.out.println("The two halves are not mirror images of each other.");
				}
			}
			if(f3 == 0) {
				System.out.println("The two halves do not contain the same numbers.");
			}
			}
		else {
			System.out.println("The two halves have different sums.");
			}
			}

	public static int calculateSum(int[] arrayInput, int n1, int n2) {
		if(n1 == n2) {
			return arrayInput[n1];
			}
		int sum = (calculateSum(arrayInput, n1, n2-1) + arrayInput[n2]);
		return sum;
		}

	public static int exactNumbersCheck(int[] firstHalf, int[] secondHalf, int n1, int n2, int f2) {
		if(f2 == firstHalf.length) {
			return f2;
			}
		else {
			if(n1>=1 && n2>=1) {
				if(firstHalf[n1-1] == secondHalf[n2-1]) {
					f2 = f2 + 1;
					return exactNumbersCheck(firstHalf, secondHalf, n1-1, secondHalf.length, f2);
					}
				else {
					return exactNumbersCheck(firstHalf, secondHalf, n1, n2-1, f2);
					}
				}
			return f2;
			}
		}

	public static int mirrorCheck(int[] firstHalf, int[] secondHalf, int n1, int n2, int f1) {
		if(f1 == firstHalf.length) {
			return f1;
			}
		else {
			if(n1>=1 && n2>=1) {
				if(firstHalf[n1-1] == secondHalf[n2-n1]) {
					f1 = f1 + 1;
					return mirrorCheck(firstHalf, secondHalf, n1-1, n2, f1);
					}
				else {
					return f1;
					}
				}
			return f1;
			}
		}
	}