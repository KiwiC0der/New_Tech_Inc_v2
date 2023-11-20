package data.template;
import logic.template.TemplateName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;

/**
 * the Food Pantry Notification System project.
 * This class sets up a connection to the Microsoft SQL database.
 *
 * @author Anteneh Demissie
 * @version 2023.05.03
 */

public class Database {

    private static final String CONNECTION_STRING = "jdbc:jtds:sqlserver://cisdbss.pcc.edu/CIS234A_New_Tech_Inc";
    private static final String USERNAME = "CIS234A_New_Tech_Inc";
    private static final String PASSWORD = "234ATeamPcc2!";
    private static String GET_TEMPLATE_NAMES = "SELECT TemplateName FROM Template;";
    private static String SAVE_TEMPLATE = "INSERT INTO Template (TemplateName, Subject, Content) VALUES (?, ?, ?);";

    private static Connection conn = null;


    private static void connect() {
        try {
            System.out.println("Testing Database connection...");

            // Create a database connection with the given username and password.
            if (conn != null) {
                return;
            } else {
                conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
                System.out.println("Database connection established successfully.");
            }
        } catch (SQLException e) {
            System.err.println("Error! Cannot connect to the database!");
            e.printStackTrace();
        }
    }

    //Method to retrieve data from the templateName column on the Template table.
    public static ArrayList<TemplateName> getTemplateName() {
        connect();
        ArrayList<TemplateName> templateNames = new ArrayList<TemplateName>();

        try {
            PreparedStatement stmt = conn.prepareStatement(GET_TEMPLATE_NAMES);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                templateNames.add(new TemplateName((rs.getString("TemplateName"))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return templateNames;
    }

    //Method to save data to the Template table.
    public static void saveTemplate(String name, String subject, String content) {
        connect();

        try {
            PreparedStatement stmt = conn.prepareStatement(SAVE_TEMPLATE);
            stmt.setString(1, name);
            stmt.setString(2, subject);
            stmt.setString(3, content);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}