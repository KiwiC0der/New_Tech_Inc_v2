package logic.sendNotification;

import data.sendnotification.Database;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class is responsible for sending the message to subscribers.
 *
 * @author Andrew Hart
 * @version 5/9/2023
 */
public class SendNotification {

    public static void sendMessage(String subject, String message) {

        String emails = Database.getEmails();

        final String username = "foodnotification3@gmail.com";

        final String password = "placeholder"; //replace with "placeholder" after testing

        Properties props = new Properties();

        props.put("mail.smtp.auth", "true");

        props.put("mail.smtp.starttls.enable", "true");

        props.put("mail.smtp.host", "smtp.gmail.com");

        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message notification = new MimeMessage(session);

            notification.setFrom(new InternetAddress("from-email@gmail.com"));

            notification.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emails));

            notification.setSubject(subject);

            notification.setContent(message, "text/html");

            Transport.send(notification);

            System.out.println("Done");

        } catch (AddressException e) {
            throw new RuntimeException(e);

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
    }
}
