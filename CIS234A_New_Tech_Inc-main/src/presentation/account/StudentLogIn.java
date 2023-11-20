/**
 * Andrew Stiers
 *
 * 05/17/2023
 *
 * Login page for users
 */

package presentation.account;

import logic.account.AccountValidate;
import presentation.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StudentLogIn {
    private JPanel rootPanel;
    private JLabel loginLabel;
    private JLabel userLabel;
    private JLabel passwordLabel;
    private JButton createPageButton;
    private JButton signInButton;
    private JButton exitButton;
    private JPasswordField passwordField;
    private JTextField loginField;

    public StudentLogIn()
    {

        rootPanel.setPreferredSize(new Dimension(600,400));

        /**
         * This will be the listener for the "createPage" button
         * that creates a "create account" page
         */
        createPageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateAccount test = new CreateAccount();
                Component comp = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(comp);
                frame.setContentPane(test.getRootPanel());
                frame.setVisible(true);

            }
        });

        /**
         * This will be a listener for the "signIn" button that
         * lets the user sign in
         */
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //tbd
                AccountValidate AV = new AccountValidate();
                AV.checkUser(loginField.getText(), passwordField.getText());
                //Switching GUIs code
                Menu test = new Menu();
                Component comp = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(comp);
                frame.setContentPane(test.getRootPanel());
                frame.setVisible(true);
            }
        });

        /**
         * This will be a listener for the exit button that will
         * exit the program
         */
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public JPanel getRootPanel()
    {
        return rootPanel;
    }
}
