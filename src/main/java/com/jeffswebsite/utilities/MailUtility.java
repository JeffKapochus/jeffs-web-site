package com.jeffswebsite.utilities;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.jeffswebsite.models.ContactSubmission;
import com.jeffswebsite.models.responses.mail.SendMailResponse;

@Component
public class MailUtility {

	@Value("${jeffswebsite.mail.host}")
	private String host;
	@Value("${jeffswebsite.mail.port}")
	private String port;
	@Value("${jeffswebsite.mail.username}")
	private String username;
	@Value("${jeffswebsite.mail.password}")
	private String password;
	@Value("${jeffswebsite.mail.toAddress}")
	private String toAddress;

	public SendMailResponse sendContactSubmissionEmail(final ContactSubmission contactSubmission) {
		final JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(this.host);
		sender.setPort(Integer.parseInt(this.port));
		sender.setUsername(this.username);
		sender.setPassword(this.password);
		final Properties props = sender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");

		final SendMailResponse response = new SendMailResponse();
		try {
			final SimpleMailMessage msg = new SimpleMailMessage();
			// For my purposes, from == to because gmail doesn't let
			// you send email from another address
			msg.setFrom(this.toAddress);
			msg.setTo(this.toAddress);
			msg.setSubject(contactSubmission.getSubject());
			msg.setText("Dear Jeff,\n\nThere is a new submission on from the contact form on jeffsweb.site\n"
					+ "The message is from " + contactSubmission.getName() + " (" + contactSubmission.getEmail()
					+ "):\n\n\n" + contactSubmission.getContent()
					+ "\n\n\nThis was an automated email from jeffsweb.site\n\nBest Wishes,\nJeff Kapochus");
			sender.send(msg);
			response.setSuccess(true);
		}
		catch (final Exception e) {
			response.setSuccess(false);
			response.setValidationMessage(e.getMessage());
		}
		return response;
	}
}
