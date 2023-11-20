/**
 * Andrew Stiers
 *
 * 05/19/23
 *
 * Class intended to validate input when trying to submit new information
 */

package logic.account;

import data.account.AccountDb;
import data.account.AccountInfo;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CreateValidate {

    private static final String bad = "!@#$%^&*()?><:}{";



    /**
     * Makes sure fields aren't empty.
     *
     * @param username is the username to validate
     * @return if valid
     */
    public boolean validateUser(String username)
    {
        String big = checkBigString(username);
        String small = checkSmallString(username);

        boolean isValid = false;
        if (username.equals("")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The username must be filled in");
        } else if (badExists(big, small)) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "The username must not contain bad characters: "
            + bad);
        } else if (checkLogin(username)) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Account creation failed!");
        }
        else {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Checks for existing username or email
     * @param login entered username or email address
     * @return returns true if already exists
     */
    private boolean checkLogin(String login) {
        boolean exists = false;
        AccountDb pullDB = new AccountDb();
        ArrayList<AccountInfo> pullAc = pullDB.getAccountInfo();

        for (AccountInfo each : pullAc) {
            if (each.getUsername().equals(login) || each.getEmailAddress().equals(login)) {
                exists = true;
                break;
            }
        }


        return exists;
    }


    /**
     * Checks the name field to make sure it isn't empty
     * @param fullName entered name
     * @return returns true if name field isn't empty
     */
    public boolean validName(String fullName) {
        String biggie = checkBigString(fullName);
        String smalls = checkSmallString(fullName);

        boolean isValid = false;

        if (fullName.equals("")) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Name field must be filled in");
        } else if (badExists(biggie, smalls)) {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Name must not contain invalid characters");
        } else {
            isValid = true;
        }
        return isValid;
    }

    /**
     * Checks for bad strings by searching each entered string
     * @param big the bigger string to be searched
     * @param small the smaller string indexing the big one
     * @return returns true if a bad character is entered
     */
    private boolean badExists(String big, String small) {
        boolean hasBad = false;

        for (int i = 0; i < big.length(); i++) {
            if (hasBad) {
                break;
            }
            for (int x = 0; x < small.length(); x++) {
                if (big.substring(i, i+1).equals(small.substring(x, x+1))) {
                    hasBad = true;
                    break;
                }
            }
        }

        return hasBad;
    }

    /**
     * Method to compare lengths of strings
     * @param str1 Entered string
     * @return Returns biggest string
     */
    private String checkBigString(String str1) {
        String biggest;
        if (str1.length() > bad.length()) {
            biggest = str1;
        } else {
            biggest = bad;
        }
        return biggest;
    }

    /**
     * Compares the entered string size against the number of bad characters
     * @param str1 entered string
     * @return returns the smallest of the strings
     */
    private String checkSmallString(String str1) {
        boolean str1Smaller = false;
        String smallest;
        if (str1.length() < bad.length()) {
            smallest = str1;
        } else {
            smallest = bad;
        }
        return smallest;
    }


    /**
     * Checks to make sure email address is valid
     * @param email
     * @return returns true if email address format is correct
     */
    public boolean validateEmail(String email)
    {
        boolean isValidEmail = false;
        int hasAt = 0;
        int hasPeriod = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.substring(i, i+1).equals("@")) {
                hasAt++;
            }
            if (email.substring(i, i+1).equals(".")) {
                hasPeriod++;
            }
        }
        if (hasAt == 1) {
            if (hasPeriod >= 1) {
                if (checkLogin(email)) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Account creation failed!");
                } else {
                isValidEmail = true;
                }
            }
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Email address format must have an '@' and '.'");
        }

        return isValidEmail;
    }

    /**
     * Method to check for a valid password
     * @param pass the entered password
     * @return returns true if valid
     */
    public boolean validPass(String pass) {
        boolean isValid = false;
        if (pass.equals("") || pass.length() < 1) {
            isValid = false;
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Passwords must not be blank");
        } else {
            isValid = true;
        }
        return isValid;
    }


    /**
     * Confirms the first and retyped passwords are the same
     * during account creation
     * @param firstPass
     * @param secondPass
     * @return returns true or false if they do or don't match
     */
    public boolean samePass(String firstPass, String secondPass)
    {
        boolean isSame = false;
        if (firstPass.equals(secondPass)) {
            isSame = true;
        } else {
            JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Passwords must be the same!");
        }
        return isSame;
    }

    /**
     * Checks if everything inputted is valid.
     * @param user the data input for the user's username
     * @param email the data input for the user's email address
     * @param pass the data input for the user's password
     * @param fullName the data input for the user's full name
     * @return returns true if everything looks correct
     */
    public boolean validateAll(String user, String fullName, String email, String pass,
                           String secPass)
    {
        boolean isOk = false;
        ArrayList<Boolean> allFields = new ArrayList<>();
        allFields.add(validateUser(user));
        allFields.add(validName(fullName));
        allFields.add(validateEmail(email));
        allFields.add(validPass(pass));
        allFields.add(samePass(pass, secPass));

        for (boolean valid : allFields) {
            if (valid) {
                isOk = true;
            } else {
                isOk = false;
                break;
            }
        }
        return isOk;
    }


}
