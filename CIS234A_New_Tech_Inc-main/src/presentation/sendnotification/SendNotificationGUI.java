package presentation.sendnotification;
import data.sendnotification.Database;
import logic.sendNotification.SendNotification;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for creating the GUI and handling
 * user input.
 *
 * @author Andrew Hart
 * @version 5/9/2023
 */
public class SendNotificationGUI {
    public String subject;

    public String message;

    private JPanel rootPanel;

    private JTextField subjectTextField1;

    private JButton sendNotificationButton1;

    private JButton exitButton1;

    private JButton clearButton1;

    private JButton useTemplateButton1;

    private JTextArea enterMessageTextArea1;

    public static void createSendNotificationGui() {
        JFrame frame = new JFrame("Food Pantry Notification System");

        frame.getContentPane().add(new SendNotificationGUI().getRootPanel());

        frame.setVisible(true);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);
    }

    private SendNotificationGUI () {
        rootPanel.setPreferredSize(new Dimension(400,300));

        clearButton1.addActionListener(e -> enterMessageTextArea1.setText(""));

        useTemplateButton1.addActionListener(e -> JOptionPane.showMessageDialog(rootPanel, "The ability to use a template has not yet been implemented."));

        sendNotificationButton1.addActionListener(e -> {
            subject = subjectTextField1.getText();

            message = enterMessageTextArea1.getText();

            if (subject.length() < 51 && subject.length() > 1 && message.length() < 257 && message.length() > 1) {
                Database.retrieveEmails();

                SendNotification.sendMessage(subject, message);

                Database.updateNotificationLog(subject, message);

                JOptionPane.showMessageDialog(rootPanel, "Message sent successfully.");

            } else if (subject.length() > 50 || subject.length() < 1) {
                JOptionPane.showMessageDialog(rootPanel, "The subject must be between 0 and 50 characters long.");
            }

            else if (message.length() > 256 || message.length() < 1) {
                JOptionPane.showMessageDialog(rootPanel, "The message must be between 0 and 256 characters long.");
            }
        });

        exitButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }
        });
    }

    public JPanel getRootPanel() {
        return rootPanel;
    }
}
