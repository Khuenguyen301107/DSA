import java.util.Scanner;



public class Lab01 {
    public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of elements in the array: ");
    int N = scanner.nextInt();
    int array[] = new int[N];
    System.out.println("Enter " + N + " elements: ");
    for(int i=0;i<N;i++){
        array[i]=scanner.nextInt();
    }
    System.out.print("Array elements are: ");
    for(int i=0;i<N;i++){
        System.out.print(array[i] + " ");
    }
    System.out.println();
    scanner.close();
    }
    
    
}

