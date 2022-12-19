// Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
import java.util.Random;

public class hw3task1 {
    public static void main (String[] args) {
        Random rand = new Random();
        int[] arr = new int[rand.nextInt(0, 20)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(-20, 20);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sortArray(arr)));

    }

    public static int[] sortArray(int[] array) {
        int middle = array.length / 2;
        if (array.length == 0) {
            return null;
        }
        else if (array.length < 2) {
            return array;
        }
        int[] arrayA = new int[middle];
        int[] arrayB = new int[array.length - middle];
        System.arraycopy(array, 0, arrayA, 0, middle);
        System.arraycopy(array, middle, arrayB, 0, array.length - middle);

        arrayA = sortArray(arrayA);
        arrayB = sortArray(arrayB);

        array = merge(arrayA, arrayB);

        return array;
    }

    public static int[] merge(int[] arrayA, int[] arrayB) {
        int[] res = new int[arrayA.length + arrayB.length];
        int counterA = 0;
        int counterB = 0;

        for (int i = 0; i < res.length; i++) {
            if (counterA == arrayA.length) {
                res[i] = arrayB[counterB];
                counterB++;
            }
            else if (counterB == arrayB.length) {
                res[i] = arrayA[counterA];
                counterA++;
            }
            else if (arrayA[counterA] < arrayB[counterB]) {
                res[i] = arrayA[counterA];
                counterA++;
            }
            else {
                res[i] = arrayB[counterB];
                counterB++;
            }
        }
        return res;
    }
}

