package main.sendnotification;
import data.sendnotification.Database;
import presentation.sendnotification.SendNotificationGUI;

/**
 * This class is responsible for starting the program.
 *
 * @author Andrew Hart
 * @version 5/9/2023
 */
public class Main {
    public static void main(String[] args) {
        SendNotificationGUI.createSendNotificationGui();
    }
}