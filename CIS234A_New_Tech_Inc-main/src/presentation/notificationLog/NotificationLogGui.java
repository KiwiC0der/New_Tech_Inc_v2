/**
Caleb Billings
4/26/2023
Class used to structure the user interface
 */
package presentation.notificationLog;
import logic.notificationLog.Log;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;

public class NotificationLogGui {
    private JPanel rootPanel;
    private JTextField startDate;
    private JTextField endDate;
    private JButton fetchLogButton;
    private JTable table1;
    private JButton backButton;
    private JButton closeButton;
    private JFrame missingFeature;



    public NotificationLogGui(){
        //Create starting JTable with all data
        DefaultTableModel model = (DefaultTableModel) table1.getModel();
        String[] columnNames = {"Subject", "Body", "Sender", "Date/Time", "#of Recipients"};
        List<Log> logs = Log.getAllData();
        model.setDataVector(null, columnNames);
        for(Log log : logs) {
            Object[] row = {log.getSubject(), log.getBody(), log.getSender(), log.getDate(), log.getRecipients()};
            model.addRow(row);
        }

        //Create date format to validate user input
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        ///button for retrieving filtered data
        fetchLogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validate startDate and endDate
                try {
                    dateFormat.parse(startDate.getText());
                    dateFormat.parse(endDate.getText());
                    //if dates are valid, clear Jtable and load queried data
                    model.setDataVector(null, columnNames);
                    List<Log> logs = Log.getData(startDate.getText(), endDate.getText());
                    for(Log log : logs) {
                        Object[] row = {log.getSubject(), log.getBody(), log.getSender(), log.getDate(), log.getRecipients()};
                        model.addRow(row);
                    }
                  //Display error message to user if dates are invalid
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null,"Error: Please enter a valid date in the format of yyyy-mm-dd");
                }
            }
        });

       //button for exiting the application
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //button for going back to the main menu
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(rootPanel);
                frame.dispose();
            }
        });

    }
    //method for getting rootPanel
    public JPanel getRootPanel(){
        return rootPanel;
    }
}
