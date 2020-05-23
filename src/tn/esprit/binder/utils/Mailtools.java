/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.binder.utils;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.net.Authenticator;
import static javafx.beans.binding.Bindings.not;
import javax.mail.MessagingException;
import static tn.esprit.binder.utils.Mailtools.sendMail;

/**
 *
 * @author Rahma
 */
public class Mailtools {
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        //Enable authentication
        properties.put("mail.smtp.auth", "true");
        //Set TLS encryption enabled
        properties.put("mail.smtp.starttls.enable", "true");
        //Set SMTP host
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //Set smtp port
        properties.put("mail.smtp.port", "587");

        //Your gmail address
        String userName = "rahma.belhadj1@esprit.tn";
        //Your gmail password
        String password = "193JFT1423";

        //Create a session with account credentials
        Session session = Session.getInstance(properties,  new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {

                return new javax.mail.PasswordAuthentication(userName, password);
            }

        });

        //Prepare email message
        Message message = prepareMessage(session, userName, recepient);

        //Send mail
        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Bonjour Chers Parents");
            //String htmlCode = "<h1> WE LOVE JAVA </h1> <br/> <h2><b>Next Line </b></h2>";
            //message.setContent(htmlCode, "text/html");
            message.setText("Bonjour , Merci de consulter notre platforme et controler l'état de votre éleve,Bonne Journéée ")
           
             ;
         
            return message;
           
           
        } catch (Exception ex) {
        }
        return null;
    }
}

    

