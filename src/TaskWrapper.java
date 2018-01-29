import java.util.TimerTask;

/**
 * Враппер чтоб хранить запускаемые таймертаски вместе с соответствующими им тасками и не плодить коллекции в Main классе
 */
public class TaskWrapper {
    private Task task;
    private TimerTask timerTask;

    /**
     * Варианты "отложить" и "завершить" сделать не удалось т.к. в main постоянно работает scanner
     * @param task
     */
    public TaskWrapper(Task task) {
        setTask(task);
        setTimerTask(new TimerTask() {
            @Override
            public void run() {
                //System.out.println("hello");
                /*if (Notification.showNotification(task)) {
                    try {
                        task.setTime(ZonedDateTime.parse(task.getTime()).plusMinutes(1).toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    TaskMap.delete(task.getTaskId());
                }*/

                /*if (Notification.showNotification(task)) {
                    try {
                        TaskMap.add(new Task(task.getName(), ZonedDateTime.parse(task.getTime()).plusMinutes(1).toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }*/
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
