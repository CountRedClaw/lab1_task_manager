import java.io.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

public class TaskMap {
    private static Map<Integer, TaskWrapper> taskMap = new HashMap<>();
    private static Timer timer = new Timer();                               // На этот таймер в методе add() навешиваются таймертаски (timer.schedule), получаемые из словаря taskMap

    public static void delete(int id) {
        taskMap.remove(id);
    }

    public static void add(Task task) throws Exception {
        if (!task.isActual()) {
            throw new Exception("Неправильное время");
        }
        TaskWrapper taskWrapper = new TaskWrapper(task);
        taskMap.put(task.getTaskId(), taskWrapper);
        ZonedDateTime zdt = ZonedDateTime.parse(taskWrapper.getTask().getTime());
        timer.schedule(taskWrapper.getTimerTask(), (zdt.toInstant().toEpochMilli() - ZonedDateTime.now(ZoneId.systemDefault()).toInstant().toEpochMilli()));
    }

    public static TaskWrapper get(int id) {
        return taskMap.get(id);
    }

    public static Map<Integer, TaskWrapper> getTaskMap() {
        return taskMap;
    }

    public static void saveToFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        List<TaskWrapper> list = new ArrayList(taskMap.values());
        List<Task> list1 = new ArrayList();
        for (TaskWrapper taskWrapper : list) {
            list1.add(taskWrapper.getTask());
        }
        oos.writeObject(list1);
        oos.flush();
        oos.close();
    }

    public static void loadFromFile() throws Exception {
        FileInputStream fis = new FileInputStream("temp.out");
        ObjectInputStream oin = new ObjectInputStream(fis);

            List<Task> list = (ArrayList<Task>) oin.readObject();
            for (Task task : list) {
                if (task.isActual()) {      // Если событие еще не просрочено, то создаются таски, в противном случае уведомляем пользователя, что событие уже произошло
                    add(task);
                } else {
                    Notification.showNotification(task, "Пока вас не было, произошло следующее событие:");
                }
            }
    }
}
