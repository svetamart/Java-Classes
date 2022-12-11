// Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class hw2task1 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("test.json");
        Scanner s = new Scanner(fr);
        String str = s.nextLine();
        fr.close();
        String[] arr = str.split(",");
        StringBuilder sb = new StringBuilder();
        String del = "' AND ";
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].replace("\"", "").
                    replace(" ", "").
                    replace(":", " = '").replace("{", "").
                    replace("}", "");
            if (!arr[i].contains("null")) {
                sb.append(arr[i] + del);
            }
        }
        String res = sb.toString();
        res = "SELECT * FROM students WHERE " + res.substring(0, res.length() - 5);
        System.out.println(res);
    }
}


