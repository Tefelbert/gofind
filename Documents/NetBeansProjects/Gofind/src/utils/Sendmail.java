/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author x22
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Sendmail {
            public static void send(final Properties props, String froms,String tos,String subjects,String bodys){
		
                String from = props.getProperty("testmail.from");
		String to = props.getProperty("testmail.to");
		String subject = props.getProperty("testmail.subject");
		String body = props.getProperty("testmail.body");
		
		Session mailSession = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("mail.user"), props.getProperty("mail.password"));
			}
		});
		Message simpleMessage = new MimeMessage(mailSession);
		
		InternetAddress fromAddress = null;
		InternetAddress toAddress = null;
		try {
			fromAddress = new InternetAddress(from);
			toAddress = new InternetAddress(to);
		} catch (AddressException e) {
			e.printStackTrace();
		}
		
		try {
			simpleMessage.setFrom(fromAddress);
			simpleMessage.setRecipient(RecipientType.TO, toAddress);
			simpleMessage.setSubject(subject);
			simpleMessage.setText(body);
						
			Transport.send(simpleMessage);			
		} catch (MessagingException e) {
			System.err.println("Error sending mail");
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args) throws IOException {
		final Properties props = new Properties();
		try {
			props.load(new FileInputStream("C:\\Users\\x22\\Documents\\NetBeansProjects\\Gofind\\src\\ressources\\sample_mail.properties"));
		} catch (FileNotFoundException e1) {
			System.err.println("Properties file not found");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Error loading properties file");
			e1.printStackTrace();
		}
		
		Sendmail.send(props,"","","","");		
	}

	}

