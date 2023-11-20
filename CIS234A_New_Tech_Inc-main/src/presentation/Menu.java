package presentation;

import main.*;
import presentation.*;
import presentation.notificationLog.NotificationLogGui;
import presentation.sendnotification.SendNotificationGUI;
import presentation.template.MainGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    private JButton sendANotifictionButton;
    private JButton createATemplateButton;
    private JButton notificationLogButton;
    private JButton logOutButton;
    private JPanel rootPanel;

    public Menu() {
        createATemplateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI.launchGUI();
            }
        });
        sendANotifictionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SendNotificationGUI.createSendNotificationGui();
            }
        });
        notificationLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.notificationLog.NotificationLog.launchGui();
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.account.Main.createAndShowGui();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }
        });
    }

    public static void launchMenuGUI() {
        JFrame newFrame = new JFrame("Food Pantry Notification System");

        newFrame.getContentPane().add(new Menu().getRootPanel());

        newFrame.pack();
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);
        newFrame.setVisible(true);
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
