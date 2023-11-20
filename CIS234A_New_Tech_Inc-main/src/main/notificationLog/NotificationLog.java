package main.notificationLog;
/**
 Caleb Billings
 4/26/2023
 This program is an interface that accepts date ranges from the user and then queries a log of all notifications that have been sent between those dates
 */
import javax.swing.*;
import presentation.notificationLog.NotificationLogGui;
import java.awt.*;

public class NotificationLog {
    public static void launchGui(){
        //Gui setup
        JFrame frame = new JFrame("Notification Log");
        frame.setPreferredSize(new Dimension(900, 600));
        frame.setContentPane(new NotificationLogGui().getRootPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                launchGui();
            }
        });
    }
}