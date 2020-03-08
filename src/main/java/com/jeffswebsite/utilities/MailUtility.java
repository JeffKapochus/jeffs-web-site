package com.jeffswebsite.utilities;

import static com.jeffswebsite.utilities.Functions.verifyContactSubmission;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import com.jeffswebsite.models.ContactSubmission;

public class MailUtility {

	private static final String HOST = "****";
	private static final int PORT = 000;
	private static final boolean SSL_FLAG = true;
	private static final String USERNAME = "webmaster@thisguywritescode.com";
	private static final String PASSWORD = "****";
	private static final String TO_ADDRESS = "Jeff.Kapochus@gmail.com";
	private static final String CC_ADDRESS = "Jeff@thisguywritescode.com";

	public static boolean SendContactSubmissionEmail(final ContactSubmission contactSubmission) {
		try {
			if (!verifyContactSubmission(contactSubmission)) {
				throw new IllegalArgumentException();
			}
			final Email email = new SimpleEmail();
			email.setHostName(HOST);
			email.setSmtpPort(PORT);
			email.setAuthenticator(new DefaultAuthenticator(USERNAME, PASSWORD));
			email.setSSLOnConnect(SSL_FLAG);
			email.setFrom(contactSubmission.getEmail(), contactSubmission.getName());
			email.setSubject(contactSubmission.getSubject());
			email.setMsg(contactSubmission.getContent());
			email.addTo(TO_ADDRESS);
			email.addCc(CC_ADDRESS);
			email.send();
		} catch (final Exception e) {
			return false;
		}
		return true;
	}

}
