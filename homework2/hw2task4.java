// калькулятор с логированием

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class hw2task4 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(hw2task4.class.getName());
        logger.setLevel(Level.INFO);
        FileHandler fh = new FileHandler("calc_log.txt");
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);

        System.out.print("Введите первое число: ");
        Scanner iScanner = new Scanner(System.in);
        double n1 = iScanner.nextDouble();
        System.out.print("'+' - сложение \n'-' - вычитание \n'*' - умножение \n'/' - деление \n" +
                "Введите символ операции: ");
        String line = iScanner.next();
        char op = line.charAt(0);
        System.out.print("Введите второе число: ");
        double n2 = iScanner.nextDouble();
        logger.info(String.valueOf(n1));
        logger.info(String.valueOf(op));
        logger.info(String.valueOf(n2));
        String res = calc(n1, n2, op);
        System.out.println(res);
        logger.info(res);
        fh.close();
    }

    public static String calc(double n1, double n2, char op){
        double result = 0;
        String ops = "+-*/";
        StringBuilder res = new StringBuilder();
        if (op == ops.charAt(0)) {
            result = n1 + n2;
            if (n2 < 0) {
                res.append(n1).append(" + ").append("(").append(n2).append(")").append(" = ").append(result);
            } else {
                res.append(n1).append(" + ").append(n2).append(" = ").append(result);
            }

        } else if (op == ops.charAt(1)) {
            result = n1 - n2;
            if (n2 < 0) {
                res.append(n1).append(" - ").append("(").append(n2).append(")").append(" = ").append(result);
            } else {
                res.append(n1).append(" - ").append(n2).append(" = ").append(result);
            }
        } else if (op == ops.charAt(2)) {
            result = n1 * n2;
            if (n2 < 0) {
                res.append(n1).append(" * ").append("(").append(n2).append(")").append(" = ").append(result);
            } else {
                res.append(n1).append(" * ").append(n2).append(" = ").append(result);
            }

        } else if (op == ops.charAt(3)) {
            if (n2 != 0) {
                result = n1 / n2;
                if (n2 < 0) {
                    res.append(n1).append(" / ").append("(").append(n2).append(")").append(" = ").append(result);
                } else {
                    res.append(n1).append(" / ").append(n2).append(" = ").append(result);
                }
            } else {
                res.append("Деление на ноль!");
            }
        }
        return res.toString();
    }
}

