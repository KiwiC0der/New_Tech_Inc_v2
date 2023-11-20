/**
 * Andrew Stiers
 *
 * 05/17/2023
 *
 * Form to create a new account.
 */

package presentation.account;


import logic.account.CreateValidate;
import data.account.AccountDb;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateAccount {
    private JPanel rootPanel;
    private JLabel createAccountLabel;
    private JLabel usernameLabel;
    private JTextField userTextField;
    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel passwordLabel;
    private JPasswordField newPasswordField;
    private JLabel retypePasswordLabel;
    private JPasswordField retypePasswordField;
    private JButton existingButton;
    private JButton clearButton;
    private JButton joinButton;
    private JButton closeButton;


    /**
     * Creates the Account GUI
     */
    public CreateAccount()
    {
        rootPanel.setPreferredSize(new Dimension(600,400));

        existingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLogIn test = new StudentLogIn();
                Component comp = (Component) e.getSource();
                JFrame frame = (JFrame) SwingUtilities.getRoot(comp);
                frame.setContentPane(test.getRootPanel());
                frame.setVisible(true);

            }
        });

        /**
         * This will be for the "clearButton" that clears
         * the form.
         */
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userTextField.setText("");
                nameTextField.setText("");
                emailTextField.setText("");
                newPasswordField.setText("");
                retypePasswordField.setText("");
            }
        });

        /**
         * This will be for the "join" button that allows
         * the new user to create an account
         */
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = userTextField.getText();
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String pass = newPasswordField.getText();
                String pass2 = retypePasswordField.getText();


                CreateValidate newTest = new CreateValidate();

                boolean temp = newTest.validateAll(user, name, email, pass, pass2);
                if (temp) {
                    AccountDb addDB = new AccountDb();
                    addDB.addAccountInfo(user, name, email, pass);
                    JOptionPane.showMessageDialog(rootPanel, "Account created successfully");
                }


            }
        });

        /**
         * This will be for the "closeButton" button that allows
         * the user to end the program
         */
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * Returns the root panel
     * @return rootPanel
     */
    public JPanel getRootPanel()
    {
        return rootPanel;
    }
}
