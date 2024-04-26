package ejercicio2.conexion;

import ejercicio2.model.Conexion;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class Mail implements Conexion {

        //provide recipient's email ID
        String to = "sandbox.smtp.mailtrap.io";
        //provide sender's email ID
        String from = "jakartafrom@example.com";
        //provide Mailtrap's username
        final String username = "300662532f9df4";
        //provide Mailtrap's password
        final String password = "34c3323d4a38aa";
        //provide Mailtrap's host address
         String host = "sandbox.smtp.mailtrap.io";
        //configure Mailtrap's SMTP server details



    @Override
    public void comunicar() {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");

            Session session = Session.getInstance(props,
                    new jakarta.mail.Authenticator() {
                            protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                            }
                    });
            try {
                    //create a MimeMessage object
                    Message message = new MimeMessage(session);
                    //set From email field
                    message.setFrom(new InternetAddress(from));
                    //set To email field
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    //set email subject field
                    message.setSubject("Email enviado desde eclipse!");
                    //set the content of the email message
                    message.setText("Feliz cumpleaños");
                    //send the email message
                    Transport.send(message);
            } catch (MessagingException e) {
                    throw new RuntimeException(e);
            }
    }
}