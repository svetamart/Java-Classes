// Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

import java.util.Scanner;
public class task1 {
    public static void main(String[] args) {
        System.out.print("Введите число N: ");

        Scanner iScanner = new Scanner(System.in);
        int n = iScanner.nextInt();

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial = factorial * i;
        }

        System.out.printf("Сумма чисел от 1 до %d равна %d \n", n, sum);
        System.out.printf("%d! = %d", n, factorial);
    }
}
