import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.
public class hw5task1 {
    public static void main (String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> phones = new ArrayList<>();
        phones.add("+79831871236");
        phones.add("+79846878968");
        map.put("Иван Иванов", phones);

        menu(map);
    }

    public static void menu (HashMap<String, ArrayList<String>> map) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("""
                    Выберите действие:\s
                    1 - добавить новый контакт\s
                    2 - просмотреть все записи\s
                    3 - выход
                    """);
            int answer = scanner.nextInt();
            if (answer == 1) {
                System.out.println(addContact(map));
            } else if (answer == 2) {
                phoneBook(map);
            } else if (answer == 3) {
                running = false;
            } else {
                System.out.println("Неизвестная команда. Пожалуйста, введите номер одного из доступных действий. \n");
            }
        }
    }

    public static void phoneBook(HashMap<String, ArrayList<String>> map) {
        for (Map.Entry<String, ArrayList<String>> entry: map.entrySet()) {
            System.out.println("Имя: " + entry.getKey());
            System.out.print("Телефон(ы): ");
            entry.getValue().forEach(System.out::println);
            System.out.println();
        }
    }

    public static HashMap<String, ArrayList<String>> addContact(HashMap<String, ArrayList<String>> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Сколько номеров нужно записать? ");
        int count = scanner.nextInt();
        System.out.println("Введите номер(а): ");
        String[] phones = new String[count];
        for (int i = 0; i < count; i++) {
           phones[i] = scanner.next();
        }
        map.put(name, new ArrayList<>(Arrays.asList(phones)));
        return map;
    }
}
