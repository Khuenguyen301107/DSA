import java.util.Random;
import java.util.Arrays;

public class Lab02Bai01 {
    public static void main(String[] args) {
        int[] sizes = { 100, 1000, 10000, 100000 };
        for (int n : sizes) {
            System.out.println("Testing N = " + n);

            int[] original = generateRandomArray(n);

            int[] array1 = Arrays.copyOf(original, original.length);
            int[] array2 = Arrays.copyOf(original, original.length);
            int[] array3 = Arrays.copyOf(original, original.length);

            bubbleSort(array1);
            insertionSort(array2);
            selectionSort(array3);
            System.out.println();

        }

    }

    public static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000000);
        }
        return array;
    }

    public static void bubbleSort(int[] array) {
        long comparisonCount = 0;
        long assignmentCount = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                comparisonCount++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }

        }
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort - Comparisons: " + comparisonCount + ", Assignments: " + assignmentCount
                + ", Time: " + (endTime - startTime) + " ns");
    }

    public static void insertionSort(int[] array) {
        long comparisonCount = 0;
        long assignmentCount = 0;
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            while (j > -1 && temp < array[j]) {
                comparisonCount++;
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
                assignmentCount++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Insertion Sort - Comparisons: " + comparisonCount + ", Assignments: " + assignmentCount
                + ", Time: " + (endTime - startTime) + " ns");
    }

    public static void selectionSort(int[] array) {
        long comparisonCount = 0;
        long assignmentCount = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                comparisonCount++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
                assignmentCount++;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Selection Sort - Comparisons: " + comparisonCount + ", Assignments: " + assignmentCount
                + ", Time: " + (endTime - startTime) + " ns");
    }

    public static void printArray(String name, long comparisonCount, long assignmentCount, long time) {
        System.out.println(name + " - Comparisons: " + comparisonCount + ", Assignments: " + assignmentCount
                + ", Time: " + time + " ns");
    }
}