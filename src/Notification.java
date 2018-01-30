
public class Notification {

    /**
     *
     * @param task
     * @param str Доп. инфа
     */
    public static void showNotification(Task task, String str) {
        System.out.println(str);
        System.out.println("Событие: " + task.getName() + " " + task.getTime());
    }
}
