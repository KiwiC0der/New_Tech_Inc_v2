package main.account;

/**
 * Andrew Stiers
 *
 * 05/16/2023
 *
 * Main class to initialize the program
 */

import presentation.account.StudentLogIn;
import javax.swing.*;

public class Main {

    public static void createAndShowGui() {
        JFrame frame = new JFrame("StudentLogin");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new StudentLogIn().getRootPanel());
        frame.pack();
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        createAndShowGui();

    }

    /**
     * Still need to finish showing messages if specific fields are blank
     * Also need to get encryptions working.
     */

}