package com.jeffswebsite.services;

import java.util.List;

import com.jeffswebsite.models.ContactSubmission;

public interface ContactSubmissionService {

	public ContactSubmission getContactSubmissionById(int id);

	public List<ContactSubmission> getAllContactSubmissions();

	public List<ContactSubmission> getContactSubmissionsByName(String name);

	public List<ContactSubmission> getContactSubmissionsByEmail(String email);

	public ContactSubmission saveContactSubmission(ContactSubmission sub);

	void removeContactSubmission(int id);

}
