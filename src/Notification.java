import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;

import java.util.Optional;
import java.util.Scanner;

public class Notification/* implements Runnable*/ {
    //private static boolean isPutAside = false;

    /**
     * т.к. приложение консольное, варианты "отложить" и "завершить" сделать не удалось т.к. в main постоянно работает scanner
     * @param task
     * @param str Доп. инфа
     */
    public static void showNotification(Task task, String str) {

        /*com.sun.javafx.application.PlatformImpl.startup(()->{});
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog with Custom Actions");
        alert.setHeaderText(task.getName() + task.getTime());
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("Отложить");
        ButtonType buttonTypeCancel = new ButtonType("Завершить", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        com.sun.javafx.application.PlatformImpl.exit();*/
        System.out.println(str);
        System.out.println("Событие: " + task.getName() + " " + task.getTime());
        /*try {
            Main.input.wait(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //new Thread(new Notification()).start();

        //return isPutAside;
        /*if (result.get() == buttonTypeOne){
            return true;
        } else {
            return false;
        }*/
    }

    /*@Override
    public void run() {

        System.out.println("Отложить на одну минуту?    y - (yes), n - (no)");
        while(true) {
            Scanner in = new Scanner(System.in);
            if (in.equals("y")) {
                isPutAside = true;
            } else if (in.equals("n")) {
                isPutAside = false;
            }
        }
    }*/
}
