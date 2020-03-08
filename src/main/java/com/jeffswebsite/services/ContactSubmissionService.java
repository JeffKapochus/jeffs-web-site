package com.jeffswebsite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jeffswebsite.models.ContactSubmission;
import com.jeffswebsite.repositories.ContactSubmissionRepository;

@Component
@Service
public class ContactSubmissionService implements IContactSubmissionService {

	@Autowired
	ContactSubmissionRepository contactSubmissionRepository;

	@Override
	public ContactSubmission getContactSubmissionById(final int id) {
		ContactSubmission sub = null;
		final Optional<ContactSubmission> tempSub = contactSubmissionRepository.findById(id);
		if (tempSub.isPresent()) {
			sub = tempSub.get();
		}
		return sub;
	}

	@Override
	public List<ContactSubmission> getAllContactSubmissions() {
		return contactSubmissionRepository.findAll();
	}

	@Override
	public List<ContactSubmission> getContactSubmissionsByName(final String name) {
		return contactSubmissionRepository.findByName(name);
	}

	@Override
	public List<ContactSubmission> getContactSubmissionsByEmail(final String email) {
		return contactSubmissionRepository.findByEmail(email);
	}

	@Override
	public ContactSubmission saveContactSubmission(final ContactSubmission sub) {
		return contactSubmissionRepository.save(sub);
	}

	@Override
	public void removeContactSubmission(final int id) {
		final ContactSubmission sub = getContactSubmissionById(id);
		sub.setIsActive(false);
		contactSubmissionRepository.save(sub);
	}

}
