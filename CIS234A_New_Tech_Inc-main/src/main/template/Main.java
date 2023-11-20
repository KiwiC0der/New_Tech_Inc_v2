package main.template;

import static presentation.template.MainGUI.launchGUI;

/**
 * GUI program for the Food Pantry Notification System project.
 * This program displays a simple GUI for using and creating templates
 * for different announcement types.
 *
 * @author Anteneh Demissie
 * @version 2023.05.03
 */

public class Main {

    // Displays the GUI.
    private static void displayGUI() {
        launchGUI();

    }

    // Runs the program.
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayGUI();
            }
        });
    }
}
