package logic.account;

import data.account.AccountDb;
import data.account.AccountInfo;

import javax.swing.*;
import java.util.ArrayList;

public class AccountValidate {

    public void checkUser(String user, String password) {
        AccountDb pullDB = new AccountDb();
        ArrayList<AccountInfo> pullAc = pullDB.getAccountInfo();
        boolean samePas = false;
        boolean sameLog = false;

        for (AccountInfo each : pullAc) {
            if (each.getEmailAddress().equals(user) || each.getUsername().equals(user)) {
                sameLog = true;
                if (each.getPassword().equals(password)) {
                    samePas = true;
                    break;
                }
            }
        }
        if (samePas && sameLog) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Logged in successfully");
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Login failed");
        }

    }
}
