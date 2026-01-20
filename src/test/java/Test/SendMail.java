package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;
import org.bouncycastle.util.Store;
import org.testng.annotations.Test;

public class SendMail {
	
	@Test
	
	public void sentEmail() throws UnsupportedEncodingException {
    	
        // Recipient's email ID needs to be mentioned.
        String to = "archana.mhatre@essenzaasolutions.com";

        // Sender's email ID needs to be mentioned
        String from = "akshay.malwadkar@essenzaasolutions.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass 
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("akshay.malwadkar@essenzaasolutions.com", "uocbvgywczwbatki");

            }

        });
        //session.setDebug(true);
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to,"suraj.mohite@essenzasolutions.com"));

            // Set Subject: header field
            message.setSubject("Automation Test Execution Report");

            Multipart multipart = new MimeMultipart();

            MimeBodyPart attachmentPart = new MimeBodyPart();

            MimeBodyPart textPart = new MimeBodyPart();

            try {

                File f =new File(".//Report//Automation Testing Report.html");

                attachmentPart.attachFile(f);
                textPart.setText("Mail Body");
                multipart.addBodyPart(textPart);
                multipart.addBodyPart(attachmentPart);

            } catch (IOException e) {

                e.printStackTrace();

            }

            message.setContent(multipart);

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
//		try {
//		EmailAttachment attachment = new EmailAttachment();
//
//        attachment.setPath("C:\\Users\\ESSENZAADEVPC17\\eclipse-workspace\\Project\\Report\\Automation Testing Report.html");
//
//        attachment.setDisposition(EmailAttachment.ATTACHMENT);
//        attachment.setDescription(" Test Execution Report");
//        attachment.setName("Automation Testing Report.html");
//
//        // Create the email message
//        MultiPartEmail email = new MultiPartEmail();
//        email.setHostName("smtp.gmail.com");
//        email.setSSLOnConnect(true);
//        email.setSmtpPort(587);
//        email.setAuthenticator(new DefaultAuthenticator("akshay.malwadkar@essenzaasolutions.com", "uocbvgywczwbatki"));
//        email.addTo("archana.mhatre@essenzaasolutions.com", "Test");
//        email.setFrom("akshay.malwadkar@essenzaasolutions.com", "Me");
//        email.setSubject("Automation Test Execution Report");
//        email.setMsg("Automation Test Execution Report");
//        email.attach(attachment);
//
//        email.send();
//        System.out.println("Mail send");
//		}
//		catch (Exception e) {
//			System.out.println(e);
//		}
        

    }

}