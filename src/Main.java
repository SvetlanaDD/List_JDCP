import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void printList(List list) {
        System.out.println("Список покупок:");
        if (list.isEmpty()) {
            System.out.println("ПУСТО");
        } else {
            int i = 1;
            for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
                String task2 = iterator.next();
                System.out.println(i + ". " + task2);
                i++;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Выберите операцию:\n 1. Добавить покупку\n 2. Показать список покупок\n" + " 3. Удалить покупку\n 4. Найти покупку\n 0. Выход\n");
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                break;
            }
            int arg = Integer.parseInt(input);
            switch (arg) {
                case 1: //addTask
                    System.out.println("Какую покупку хотите добавить?");
                    String task1 = scanner.nextLine();
                    list.add(task1);
                    System.out.println("Итого в списке покупок: " + list.size());
                    break;
                case 2: //printList
                    printList(list);
                    break;
                case 3: //dellTask
                    printList(list);
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String number = scanner.nextLine();
                    try {
                        int numberDell = Integer.parseInt(number);
                        String dellTask = list.get(numberDell - 1);
                        list.remove(numberDell - 1);
                        System.out.println("Покупка `" + dellTask + "` удалена, список покупок:");
                    } catch (RuntimeException e) {
                        list.remove(number);
                        System.out.println("Покупка `" + number + "` удалена.");
                    }
                    printList(list);
                    break;
                case 4: //findTask
                    String queryLower = scanner.nextLine().toLowerCase();
                    int i = 1;
                    System.out.println("Найдено:");
                    for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
                        String task2 = iterator.next();
                        String itemLower = task2.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println(i + ". " + task2);
                        }
                        i++;
                    }
                    System.out.println("ПУСТО");
                    break;
                default:
                    System.out.println("Не верно введен номер действия\n");
                    break;
            }
        }
    }
}
