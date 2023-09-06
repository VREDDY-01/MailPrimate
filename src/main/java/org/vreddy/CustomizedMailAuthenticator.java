package org.vreddy;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizedMailAuthenticator extends Authenticator {
	@Override
	public PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(MailConstants.SENDER, MailConstants.PASSWORD);
	}
}
