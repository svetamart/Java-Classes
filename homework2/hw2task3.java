// Дана json строка (можно сохранить в файл и читать из файла)
//[{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
// {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
// {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида:
// Студент [фамилия] получил [оценка] по предмету [предмет].
//Пример вывода:
//Студент Иванов получил 5 по предмету Математика.
//Студент Петрова получил 4 по предмету Информатика.
//Студент Краснов получил 5 по предмету Физика.


import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class hw2task3 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("C:/Users/79818/Desktop/Java/class 1/homework2/students.json");
        Scanner s = new Scanner(fr);
        while (s.hasNextLine()) {
            String[] line = s.nextLine().split(",");
            for (int i = 0; i < line.length; i++) {
                line[i] = line[i].replace("\"", "").
                        replace(" ", "").
                        replace("{", "").
                        replace("}", "");
            }
            fr.close();
            System.out.println(result(line));
            }
        }
        public static StringBuilder result(String[] arr) {
            StringBuilder sb = new StringBuilder();
            String[] lastName = arr[0].split(":");
            String[] grade = arr[1].split(":");
            String[] subject = arr[2].split(":");
            sb.append("Студент ").append(lastName[1]).append(" получил(а) ").append(grade[1]).
                    append(" по предмету ").append(subject[1]);
            return sb;
        }
    }




