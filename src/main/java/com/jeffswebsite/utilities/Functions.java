package com.jeffswebsite.utilities;

import com.jeffswebsite.models.ContactSubmission;

public class Functions {

	public static boolean verifyId(final int id) {
		if (id <= 0) {
			return false;
		}
		return true;
	}

	public static String verifyContactSubmission(final ContactSubmission sub) {
		final StringBuilder errorList = new StringBuilder();
		if (sub == null) {
			errorList.append("Contact Submission is null.");
		}
		if (sub.getName() == "" || sub.getName() == " " || sub.getName() == null) {
			errorList.append("Contact Submission name is malformed.");
		}
		if (sub.getEmail() == "" || sub.getEmail() == " " || sub.getEmail() == null) {
			errorList.append("Contact Submission email is malformed.");
		}
		if (sub.getSubject() == "" || sub.getSubject() == " " || sub.getSubject() == null) {
			errorList.append("Contact Submission subject is malformed.");
		}
		if (sub.getContent() == "" || sub.getContent() == " " || sub.getContent() == null) {
			errorList.append("Contact Submission content is malformed.");
		}
		return errorList.toString();
	}
}
