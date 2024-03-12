package BasicPractice;
import java.util.Arrays;

public class MultiDimensionalArrays {
    public static void main(String[] args){
        int [][] multiArray1 = new int [2] [5];
        multiArray1 [0][0] = 5;
        multiArray1 [0][1] = 4;
        multiArray1 [0][2] = 3;
        multiArray1 [0][3] = 2;
        multiArray1 [0][4] = 1;
        System.out.println(Arrays.deepToString(multiArray1));
            //Above is fine but you can also add values to the array by doing what is done below
        int [][] multiArray2 = {{1, 2, 2, 4}, {1, 2, 3}};
        System.out.println(Arrays.deepToString(multiArray2));
    }

}
