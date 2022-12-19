// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Scanner;

public class hw3task2 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int n = scan.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add((int) (Math.random() * 30));
        }
        System.out.print("Исходный массив: ");
        System.out.println(array);
        array.removeIf(x -> x % 2 == 0);
        System.out.print("Массив без четных чисел: ");
        System.out.println(array);
        scan.close();

    }
}
