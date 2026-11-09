import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array){
        for(int i=0;i<array.length;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp = array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
    }
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array:  ");
        int size = scanner.nextInt();
        int[] array= new int[size];
        System.out.print("Enter "+size+" elements: ");
        for(int i=0;i<size;i++){
            array[i]=scanner.nextInt();
        }
        System.out.print("Arrays elements are: ");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        } System.out.println();
        selectionSort(array);
        System.out.println("Array after sorting is: " + Arrays.toString(array));
        scanner.close();
    }
    
}
