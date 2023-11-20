package data.sendnotification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 * This class is responsible for accessing the database,
 * retrieving data, and updating the message log.
 *
 * @author Andrew Hart
 * @version 5/9/2023
 */
public class Database {
    private static final String CONNECTION_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/CIS234A_New_Tech_Inc";

    private static final String USERNAME = "CIS234A_New_Tech_Inc";

    private static final String PASSWORD = "234ATeamPcc2!";

    private static Connection conn = null;

    private static Statement stmt = null;

    private static ResultSet emails = null;

    private static String updateLogTemplate = "INSERT INTO Notification (Subject, Message, Date, NumOfRecipients) VALUES (?, ?, GETDATE(), ?)";

    private static int totalRecipients = 0;

    public static String emailList = "";

    public static void retrieveEmails() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

            stmt = conn.createStatement();

            emails = stmt.executeQuery("SELECT Email FROM dbo.UserAccount");

            while (emails.next()) {
                totalRecipients++;

                emailList = (emailList + emails.getString(1) + ", ");
            }


        } catch (SQLException e) {
            System.err.println("An Error has occurred! See message below.");

            e.printStackTrace();
        }
    }

    public static void updateNotificationLog(String subject, String message) {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);

            PreparedStatement stmt = conn.prepareStatement(updateLogTemplate);

            stmt.setString(1, subject);

            stmt.setString(2, message);

            stmt.setInt(3, totalRecipients);

            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("An Error has occurred! See message below.");

            e.printStackTrace();
        }
    }

    public static String getEmails() {
        return emailList;
    }
}
