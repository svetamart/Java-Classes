// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class hw4task1 {
    public static void main (String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        Random rand = new Random();

        System.out.println("Исходный список: " + fillList(rand, list));
        System.out.println("Перевернутый список: " + reverseList(list));

    }

    public static LinkedList<Integer> fillList (Random rand, LinkedList<Integer> list) {
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));
        list.add(rand.nextInt(-10, 21));

        return list;
    }

    public static LinkedList<Integer> reverseList (LinkedList<Integer> list) {
        LinkedList<Integer> rev = new LinkedList<>(list);
        Collections.reverse(rev);
        return rev;
    }
}
