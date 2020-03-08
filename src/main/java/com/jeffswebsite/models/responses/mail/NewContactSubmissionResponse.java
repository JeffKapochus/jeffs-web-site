package com.jeffswebsite.models.responses.mail;

import org.springframework.http.HttpStatus;

import com.jeffswebsite.models.ContactSubmission;

public class NewContactSubmissionResponse {

	private ContactSubmission submission;
	private SendMailResponse mailResponse;
	private HttpStatus httpStatus;
	private String validationMessage;

	public ContactSubmission getSubmission() {
		return submission;
	}

	public void setSubmission(final ContactSubmission submission) {
		this.submission = submission;
	}

	public SendMailResponse getMailResponse() {
		return mailResponse;
	}

	public void setMailResponse(final SendMailResponse mailResponse) {
		this.mailResponse = mailResponse;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(final HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(final String validationMessage) {
		this.validationMessage = validationMessage;
	}
}
