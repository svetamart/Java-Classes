// Вывести все простые числа от 1 до 1000
public class task2 {
    public static void main(String[] args) {
        for (int i = 2; i <= 1000; i++) {
            if (CheckIfPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    public static boolean CheckIfPrime(int number) {
        for (int i = 2; i <= number / 2; i++) {
            int remainder = number % i;
            if (remainder == 0) {
                return false;
            }
        }
        return true;
    }
}





