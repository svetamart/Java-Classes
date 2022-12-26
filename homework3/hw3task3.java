// Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.*;


public class hw3task3 {
    public static void main (String[] args) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите длину массива: ");
        int n = scan.nextInt();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            array.add(random.nextInt(-20, 21));
        }
        System.out.println(array);
        Collections.sort(array);
        System.out.println("Максимальный элемент массива: " + array.get(array.size() - 1));
        System.out.println("Минимальный элемент массива: " + array.get(0));
        System.out.println("Среднее арифметическое элементов массива: " + arithmeticMean(array));

        scan.close();
    }
    public static Double arithmeticMean(ArrayList<Integer> array) {
        int sum = 0;
        for (Integer i : array) {
            sum += i;
        }
        return (double) sum / array.size();
    }
}
