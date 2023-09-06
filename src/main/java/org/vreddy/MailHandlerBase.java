package org.vreddy;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandlerBase {
	public void sendMail(){
		//properties
		Properties sysPropertiesMap = System.getProperties();
		sysPropertiesMap.put("mail.smtp.host","smtp.gmail.com");//smtp server
		sysPropertiesMap.put("mail.smtp.port","465");//server port
		sysPropertiesMap.put("mail.smtp.ssl.enable","true");//ssl-secure socket layer
		sysPropertiesMap.put("mail.smtp.auth","true");//authentication

		//authentication
		Authenticator mailAuthenticator = new CustomizedMailAuthenticator();
		Session mailSession = Session.getInstance(sysPropertiesMap,mailAuthenticator);

		//build the mail
			//--> mime object
		MimeMessage mailMessage = new MimeMessage(mailSession);
		try {
			mailMessage.setFrom(MailConstants.SENDER);
			mailMessage.setSubject("Check Mail App Test - 01");
			mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstants.RECIPIENT));
			mailMessage.setText("Hi I am vishnu trying to teach mailing through java");

			Transport.send(mailMessage);
		}catch (Exception e){
			System.out.println("Some error while preparing mail body");
			System.out.println(e.getMessage());
		}
	}
}
