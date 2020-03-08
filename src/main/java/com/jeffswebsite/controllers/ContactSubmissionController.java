package com.jeffswebsite.controllers;

import static com.jeffswebsite.utilities.Functions.verifyContactSubmission;
import static com.jeffswebsite.utilities.Functions.verifyId;
import static com.jeffswebsite.utilities.MailUtility.SendContactSubmissionEmail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jeffswebsite.models.ContactSubmission;
import com.jeffswebsite.services.ContactSubmissionService;

@Component
@Controller("contactController")
public class ContactSubmissionController {

	@Autowired
	ContactSubmissionService contactSubmissionService;;

	// @GetMapping(value = "/contactSubmission")
	// @CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<ContactSubmission>> getAllContactSubmissions() {
		List<ContactSubmission> subs = new ArrayList<ContactSubmission>();
		HttpStatus status = HttpStatus.OK;
		try {
			subs = contactSubmissionService.getAllContactSubmissions();
		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<List<ContactSubmission>>(subs, status);
	}

	// @GetMapping(value = "/contactSubmission/{id}")
	// @CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<ContactSubmission> getContactSubmissionById(@PathVariable("id") final int id) {
		ContactSubmission sub = null;
		HttpStatus status = HttpStatus.OK;
		try {
			if (!verifyId(id)) {
				throw new IllegalArgumentException();
			}
			sub = contactSubmissionService.getContactSubmissionById(id);
		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ContactSubmission>(sub, status);
	}

	@PostMapping("/contactSubmission")
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<ContactSubmission> newContactSubmission(@RequestBody ContactSubmission sub) {
		HttpStatus status = HttpStatus.OK;
		try {
			if (!verifyContactSubmission(sub)) {
				throw new IllegalArgumentException();
			}
			sub = contactSubmissionService.saveContactSubmission(sub);
			SendContactSubmissionEmail(sub);

		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ContactSubmission>(sub, status);
	}

	@DeleteMapping("/contactSubmission/{id}")
	public ResponseEntity<Boolean> removeContactSubmission(@PathVariable("id") final int id) {
		HttpStatus status = HttpStatus.OK;
		Boolean deleted = true;
		try {
			if (!verifyId(id)) {
				throw new IllegalArgumentException();
			}
			contactSubmissionService.removeContactSubmission(id);
		} catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			deleted = false;
		}
		return new ResponseEntity<Boolean>(deleted, status);
	}

}
