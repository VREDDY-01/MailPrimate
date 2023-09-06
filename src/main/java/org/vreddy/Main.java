package org.vreddy;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starting to send mail");

		MailHandlerBase mailHandler = new MailHandlerBase();
		mailHandler.sendMail();
	}
}