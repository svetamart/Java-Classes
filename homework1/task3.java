// Реализовать простой калькулятор
import java.util.Objects;
import java.util.Scanner;
public class task3 {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        Scanner iScanner = new Scanner(System.in);
        double n1 = iScanner.nextDouble();
        System.out.print("1 - сложение \n2 - вычитание \n3 - умножение \n4 - деление \n" +
                "Введите номер операции: ");
        int op = iScanner.nextInt();
        System.out.print("Введите второе число: ");
        double n2 = iScanner.nextDouble();

        double result = 0;
        if (op == 1) {
           result = n1 + n2;
            if (n2 < 0) {
                System.out.printf("%f + (%f) = %f", n1, n2, result);
            } else {
                System.out.println(n1 + " + " + n2 + " = " + result);
            }

        } else if (op == 2) {
            result = n1 - n2;
            if (n2 < 0) {
                System.out.printf("%f - (%f) = %f", n1, n2, result);
            } else {
                System.out.println(n1 + " - " + n2 + " = " + result);
            }
        } else if (op == 3) {
           result = n1 * n2;
            if (n2 < 0) {
                System.out.printf("%f * (%f) = %f", n1, n2, result);
            } else {
                System.out.println(n1 + " * " + n2 + " = " + result);
            }

        } else if (op == 4) {
            if (n2 != 0) {
                result = n1 / n2;
                if (n2 < 0) {
                    System.out.printf("%f / (%f) = %f", n1, n2, result);
                } else {
                    System.out.println(n1 + " / " + n2 + " = " + result);
                }
            } else {
                System.out.println("Деление на ноль!");
            }
        }
    }

}

