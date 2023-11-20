/**
 * Caleb Billings
 * 5/10/2023
 * Class used for email log objects
 */
package logic.notificationLog;

import data.notificationLog.Database;

import java.util.List;

public class Log {
    private final String subject;
    private final String body;
    private final String sender;
    private final String date;
    private final int recipients;


    public Log(String subject, String body, String sender, String date, int recipients) {
        this.subject = subject;
        this.body = body;
        this.sender = sender;
        this.date = date;
        this.recipients = recipients;
    }


    public String getSubject() {return subject;}
    public String getBody() {return body;}
    public String getSender() {return sender;}
    public String getDate() {return date;}
    public int getRecipients() {return recipients;}


    public static List<Log> getData (String startDate, String endDate) {
        List<Log> data = Database.readLogs(startDate, endDate);
        return(data);
    }

    public static List<Log> getAllData () {
        List<Log> data = Database.readAllLogs();
        return(data);
    }

}



