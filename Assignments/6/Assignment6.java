import java.util.Scanner;

public class Assignment6 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("How many integers are you going to input?");
        int size = scan.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the numbers: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println("What type of sort would you like to use?");
        System.out.println("Bubble Sort: 1");
        System.out.println("Merge Sort: 2");
        System.out.println("Insertion Sort: 3");
        System.out.println("Shell Sort: 4");
        System.out.println("Quick sort: 5");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                bubbleSort(arr);
                break;
            case 2:
                mergeSort(arr);
                break;
            case 3:
                insertionSort(arr);
                break;
            case 4:
                shellSort(arr);
                break;
            case 5:
                quickSort(arr, 0, arr.length-1);
                break;
            default:
                break;
        }

        System.out.print("The sorted array without duplicates removed: ");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
        System.out.println("");
        System.out.print("The sorted array with duplicates removed: ");
        removeDuplicates(arr);
        /*for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }*/
    }

    public static void removeDuplicates(int[] arr){
        int end = arr.length;
        for (int i=0; i<=end; i++){
            for (int j=i+1; j<end; j++){
                if (arr[i]==arr[j]){
                    int shiftLeft = j; 
                    for (int k=j+1; k<end; k++, shiftLeft++){
                        arr[shiftLeft] = arr[k];
                    }                 
                    //arr[j] = arr[j+1];
                    end--;
                    j--;
                }
            }
        }
        for(int p=0; p<end; p++){
            System.out.print(arr[p] + " ");
        }
    }
    
    public static int[] bubbleSort(int[] arr){
        for(int i=arr.length - 1; i>0; i--){
            for(int j=0; j<i;j++){
                if(arr[j] > arr[j +1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;

                }
            }
        }
        return arr;
    }
    public static int[] selectionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = arr[i];
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]<min){
                    min = arr[j];
                    minIndex = j;
                }
            }
        if(minIndex!=i){
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        }
        return arr;
    }
    public static int[] insertionSort(int[] arr){
        for(int i=1; i<arr.length; i++){
            int tmp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j]>tmp){
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = tmp;
        }
        return arr;
    }
    public static int[] shellSort(int[] arr){
        /*int h = 1;
        while(h<=arr.length){
            h = h*3 + 1;
        }
        while(h>0){
            for(int i=2*h; i<arr.length; i+=h){
                int tmp = arr[2*h];
                int k = i;
                while(k>0 && arr[k-h]>tmp){
                    arr[k] = arr[k-h];
                    k-=h;
                }
                arr[k] = tmp;
            }
            h = (h-1)/3;
        }
        return arr;*/

        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i += 1){
                int temp = arr[i];
                int j;
                for(j=i; j>=gap && arr[j-gap]>temp; j-=gap)
                    arr[j] = arr[j-gap];
                arr[j] = temp;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int arr[]){
        int[ ] tmpArray = new int[arr.length];
        mergeSort(arr, tmpArray, 0, arr.length - 1 );
        return arr;
    }

    private static void mergeSort(int arr[], int tmpArray[], int left, int right){
        if(left < right){
            int center = (left + right)/2;
            mergeSort(arr, tmpArray, left, center);
            mergeSort(arr, tmpArray, center+1, right);
            merge(arr, tmpArray, left, center+1, right);
        }
    }
    public static void merge(int arr[], int tmpArray[], int leftPos, int rightPos, int rightEnd){
        int leftEnd = rightPos-1;
        int tmpPos = leftPos;
        int numElements = rightEnd-leftPos+1;                           
        while(leftPos<=leftEnd && rightPos<= rightEnd)
            if(arr[leftPos]<=(arr[rightPos]))                       //(arr[leftPos].compareTo(arr[rightPos])<=0)
                tmpArray[tmpPos++] = arr[leftPos++];
            else
                tmpArray[tmpPos++] = arr[rightPos++];
        while(leftPos<=leftEnd)
            tmpArray[tmpPos++] = arr[leftPos++];
        while(rightPos<=rightEnd)
            tmpArray[tmpPos++] = arr[rightPos++];
        for(int i=0; i<numElements; i++, rightEnd--)
            arr[rightEnd] = tmpArray[rightEnd];
    }
    public static int partition(int arr[], int low, int high){
        int pivot = arr[high]; 
        int i = (low-1);
        for (int j=low; j<high; j++){
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static int[] quickSort(int [ ] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
        return arr;
    }
}