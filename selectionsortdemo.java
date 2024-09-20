import java.util.*;
public class selectionsortdemo
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter how many elements to be insert: ");
        int n=sc.nextInt();
        int[] arr=new int[n];

        System.out.println("Enter the "+ n+" Element: ");
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();

        }

        System.out.println("Original array: "+ Arrays.toString(arr));
        
        selectionSort(arr);

        System.out.println("Inserted array: "+ Arrays.toString(arr));



    }

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}