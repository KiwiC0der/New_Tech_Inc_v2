/**
 Caleb Billings
 4/26/2023
 Class used to connect and communicate with database
 */
package data.notificationLog;

import logic.notificationLog.Log;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    //DB Credentials
    private static final String DB_URL = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/CIS234A_New_Tech_Inc";
    private static final String USERNAME = "CIS234A_New_Tech_Inc";
    private static final String PASSWORD = "234ATeamPcc2!";

    //prepared Statements
    private static final String  GET_LOGS_SQL = "USE CIS234A_New_Tech_Inc SELECT * FROM Notification WHERE Date BETWEEN ? AND ?";
    private static final String GET_ALL_LOGS_SQL = "USE CIS234A_New_Tech_Inc SELECT * FROM Notification";

    /**
     * Create and return a connection to the database
     * @return connection
     * @throws SQLException
     */
    private static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        return connection;
    }

    /**
     * Connects to the database returns the results of the prepared statement
     * @return List of Logs
     */
    public static List<Log> readLogs(String start, String end) {
        List<Log> logs = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(GET_LOGS_SQL);
        ) {
            stmt.setString(1, start);
            stmt.setString(2, end);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                logs.add(new Log(rs.getString("Subject"),
                        rs.getString("Message"),
                        rs.getString("Sender"),
                        rs.getString("Date"),
                        rs.getInt("NumOfRecipients")));
            }
        }
        catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        return logs;
    }

    /**
     * Gets all log of all notifications for starting window.
     * @return List of Logs
     */
    public static List<Log> readAllLogs() {
        List<Log> logs = new ArrayList<>();
        try (
                Connection connection = getConnection();
                PreparedStatement stmt = connection.prepareStatement(GET_ALL_LOGS_SQL);
        ) {

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                logs.add(new Log(rs.getString("Subject"),
                        rs.getString("Message"),
                        rs.getString("Sender"),
                        rs.getString("Date"),
                        rs.getInt("NumOfRecipients")));
            }
        }
        catch (SQLException e) {
            System.err.println("ERROR: " + e.getMessage());
            e.printStackTrace();
        }
        return logs;
    }
}
