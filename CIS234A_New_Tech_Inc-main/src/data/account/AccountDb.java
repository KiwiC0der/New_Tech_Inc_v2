/**
 * Andrew Stiers
 *
 * 05/15/2023
 *
 * Class to pull and push data from the database
 */

package data.account;

import java.sql.*;
import java.util.ArrayList;

public class AccountDb {
    private static final String ACCOUNT_DB = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/CIS234A_New_Tech_Inc";

    private static final String USERNAME = "CIS234A_New_Tech_Inc";

    private static final String PASSWORD = "234ATeamPcc2!";

    private static final String ACCOUNT_SQL = "SELECT Username, Email, Password FROM UserAccount";


    private static final String NEW_ACCOUNT_SQL = "INSERT INTO UserAccount " +
            "(Username, Name, Email, Password, Role) VALUES (?, ?, ?, ?, ?)";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ACCOUNT_DB, USERNAME, PASSWORD);
    }

    public ArrayList<AccountInfo> getAccountInfo()
    {
        ArrayList<AccountInfo> accounts = new ArrayList<>();
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(ACCOUNT_SQL);
                ResultSet rs = stmt.executeQuery();
                ) {
            while (rs.next()) {
                accounts.add(new AccountInfo(
                        rs.getString("Username"),
                        rs.getString("Email"),
                        rs.getString("Password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;

    }

    public void addAccountInfo(String createUsername, String createName,
                               String createEmail, String createPassword)
    {
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(NEW_ACCOUNT_SQL);
                ) {

            stmt.setString(1, createUsername);
            stmt.setString(2, createName);
            stmt.setString(3, createEmail);
            stmt.setString(4, createPassword);
            stmt.setString(5, "Subscriber");

            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
