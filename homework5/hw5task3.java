import java.util.Arrays;
import java.util.Random;

// Реализовать алгоритм пирамидальной сортировки (HeapSort). (Можно использовать массивы)
public class hw5task3 {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = rand.nextInt(5, 20);
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(-100, 101);
        }
        System.out.print("Исходный массив: ");
        System.out.println(Arrays.toString(array));
        System.out.print("Отсортированный массив: ");
        System.out.println(Arrays.toString(sort(array)));


    }
    public static int[] sort(int[] arr)
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapSort(arr, n, i);

        for (int i = n - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapSort(arr, i, 0);
        }

        return arr;
    }
    public static void heapSort(int[] arr, int n, int i)
    {
        int max = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left < n && arr[left] > arr[max]) {
            max = left;
        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;
            heapSort(arr, n, max);
        }
    }
}
