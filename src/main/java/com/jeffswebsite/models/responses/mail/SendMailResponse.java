package com.jeffswebsite.models.responses.mail;

public class SendMailResponse {

	private String emailId;
	private String validationMessage;
	private boolean success;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(final String emailId) {
		this.emailId = emailId;
	}

	public SendMailResponse() {
	}

	public SendMailResponse(final String val, final boolean scs) {
		this.validationMessage = val;
		this.success = scs;
	}

	public String getValidationMessage() {
		return validationMessage;
	}

	public void setValidationMessage(final String validationMessage) {
		this.validationMessage = validationMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(final boolean success) {
		this.success = success;
	}
}
