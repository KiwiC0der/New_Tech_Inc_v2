package presentation.template;

import javax.swing.*;

/**
 * GUI program for the Food Pantry Notification System project.
 * This class launches the first GUI of the program.
 *
 * @author Anteneh Demissie
 * @version 2023.05.03
 */
public class MainGUI {

    // setups the GUI.
    public static void launchGUI() {
        JFrame frame = new JFrame("Food Pantry Notification System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(new TemplateGUI().getRootPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
