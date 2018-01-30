import java.util.TimerTask;

/**
 * Враппер для хранения запускаемых таймертасков вместе с соответствующими им тасками. Поэтому теперь можно обойтись одной коллекцией в TaskMap (Map<Integer, TaskWrapper> taskMap)
 */
public class TaskWrapper {
    private Task task;
    private TimerTask timerTask;

    public TaskWrapper(Task task) {
        setTask(task);
        setTimerTask(new TimerTask() {
            @Override
            public void run() {
                Notification.showNotification(task, "");
                TaskMap.delete(task.getTaskId());

            }
        });
    }

    public TimerTask getTimerTask() {
        return timerTask;
    }

    public void setTimerTask(TimerTask timerTask) {
        this.timerTask = timerTask;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return task.toString();
    }
}
