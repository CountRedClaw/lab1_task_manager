import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        fillData();

        while(true) {
            int choice = menu();
            switch (choice) {
                case 1:
                    showTasks();
                    break;
                case 2:
                    addTask();
                    break;
                case 3:
                    deleteTask();
                    break;
                case 4:
                    saveTasks();
                    break;
                case 0:
                    saveTasks();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Такого пункта нет, повторите ввод");
            }
        }
    }

    /**
     * Заполнение массива сразу после включения
     */
    private static void fillData() {
        try {
            TaskMap.loadFromFile();
        } catch (Exception ignored) {
        }
    }

    public static void deleteTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите id задачи, которую нужно удалить");
        try {
            int id = input.nextInt();
            TaskMap.delete(id);
        } catch (Exception e) {
            System.out.println("Ошибка, попробуйте еще раз");
        }
    }

    public static void addTask() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите название новой задачи");
        String name = input.nextLine();
        System.out.println("Введите время новой задачи");
        String time = input.nextLine();
        try {
            Task task = new Task(name, time);
            TaskMap.add(task);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void saveTasks() {
        try {
            TaskMap.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showTasks() {
        System.out.printf("%5s%20s%9s\n", "id", "Название", "Время");
        System.out.println("--------------------------------------------------");
        Map<Integer, TaskWrapper> taskMap = TaskMap.getTaskMap();
        taskMap.forEach((key, value) -> System.out.println(value.toString()));
    }

    public static int menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Меню:");
        System.out.println("1 - Показать задачи");
        System.out.println("2 - Добавить задачу");
        System.out.println("3 - Удалить задачу");
        System.out.println("4 - Сохранить задачи");
        System.out.println("0 - Выйти");

        String result;

        while (true) {          // Ждём, пока пользователь не введёт число от 0 до 4
            result = input.nextLine();
            if (result.matches("[0-4]")) {
                break;
            }
        }

        return Integer.parseInt(result);
    }
}
