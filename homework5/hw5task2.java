//Пусть дан список сотрудников:
//
//        Иван Иванов
//        Светлана Петрова
//        Кристина Белова
//        Анна Мусина
//        Анна Крутова
//        Иван Юрин
//        Петр Лыков
//        Павел Чернов
//        Петр Чернышов
//        Мария Федорова
//        Марина Светлова
//        Мария Савина
//        Мария Рыкова
//        Марина Лугова
//        Анна Владимирова
//        Иван Мечников
//        Петр Петин
//        Иван Ежов
//
//        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//        Отсортировать по убыванию популярности.

import java.util.*;
import java.util.function.Function;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class hw5task2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Иванов", "Иван");
        map.put("Петрова", "Светлана");
        map.put("Белова", "Кристина");
        map.put("Мусина", "Анна");
        map.put("Крутова", "Анна");
        map.put("Юрин", "Иван");
        map.put("Лыков", "Петр");
        map.put("Чернов", "Павел");
        map.put("Чернышов", "Петр");
        map.put("Федорова", "Мария");
        map.put("Светлова", "Марина");
        map.put("Савина", "Мария");
        map.put("Рыкова", "Мария");
        map.put("Лугова", "Марина");
        map.put("Владимирова", "Анна");
        map.put("Мечников", "Иван");
        map.put("Петин", "Петр");
        map.put("Ежов", "Иван");

        System.out.println(Arrays.toString(nameList(map)));
        System.out.println(countNames(nameList(map)));
        sortMap(countNames(nameList(map)));
    }

    public static String[] nameList(HashMap<String, String> map) {
        ArrayList<String> array = new ArrayList<>(map.values());
        String[] str = new String[array.size()];
        for (int i = 0; i < array.size(); i++) {
            str[i] = array.get(i);
        }
        return str;
    }

    public static Map<String, Long> countNames(String[] array) {
        Map<String, Long> count = Arrays.stream(array)
                .collect(groupingBy(Function.identity(), counting()));
        count.entrySet().removeIf(entry -> entry.getValue() == 1);
        return count;
    }

    public static void sortMap (Map<String, Long> map) {
        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).forEach(System.out::println);
    }
}
