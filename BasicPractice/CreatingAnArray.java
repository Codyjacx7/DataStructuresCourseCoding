package BasicPractice;
import java.util.Arrays;

public class CreatingAnArray{
    public static void main(String[] args){
        int [] firstArray = new int [10];
        System.out.println(Arrays.toString(firstArray));
    
        int [] secondArray = {2, 2, 1, 5, 4};
        System.out.println(Arrays.toString(secondArray));
        System.out.println("The second array has a length of " + secondArray.length);
        Arrays.sort(secondArray);
        System.out.println(Arrays.toString(secondArray));
    }


}