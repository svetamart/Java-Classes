// Реализуйте алгоритм сортировки пузырьком числового массива,
// результат после каждой итерации запишите в лог-файл.

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw2task2 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(hw2task2.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("arraySortLog.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        System.out.print("Введите длину массива: ");
        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();

        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(0, 15);
        }
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array, logger)));
    }

    public static int[] sort(int[] array, Logger logger) {
        boolean isSorted = false;
        int tmp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    logger.info(Arrays.toString(array));
                }
            }
        }
        return array;
    }
}
