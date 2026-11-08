import java.util.Scanner;
import java.util.Arrays;
public class BubbleSort {
   public static void bubbleSort(int[] array) {
    for(int i=array.length-1;i>0;i--){
        for(int j=0; j<i;j++){
            if(array[j]>array[j+1]){
                int temp = array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
        }
    }
   }
   public static void main(String[] args){
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
   bubbleSort(array);
   System.out.println("Array after sorting is: " + Arrays.toString(array));
   scanner.close();
}
}