package com.thisguywritescode.utilities;

import com.thisguywritescode.models.ContactSubmission;

public class Functions {

	public static boolean verifyId(final int id) {
		if (id <= 0) {
			return false;
		}
		return true;
	}

	public static boolean verifyContactSubmission(final ContactSubmission sub) {
		if (sub == null || sub.getName() == "" || sub.getName() == " " || sub.getName() == null || sub.getEmail() == ""
				|| sub.getEmail() == " " || sub.getEmail() == null || sub.getSubject() == "" || sub.getSubject() == " "
				|| sub.getSubject() == null || sub.getContent() == "" || sub.getContent() == " "
				|| sub.getContent() == null) {
			return false;
		}
		return true;
	}
}
