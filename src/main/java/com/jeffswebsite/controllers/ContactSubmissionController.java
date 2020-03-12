package com.jeffswebsite.controllers;

import static com.jeffswebsite.utilities.Functions.verifyContactSubmission;
import static com.jeffswebsite.utilities.Functions.verifyId;

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
import com.jeffswebsite.models.responses.mail.NewContactSubmissionResponse;
import com.jeffswebsite.models.responses.mail.SendMailResponse;
import com.jeffswebsite.services.ContactSubmissionService;
import com.jeffswebsite.utilities.MailUtility;

@Component
@Controller("contactController")
public class ContactSubmissionController {

	@Autowired
	ContactSubmissionService contactSubmissionService;
	@Autowired
	MailUtility mailUtility;

	// @GetMapping(value = "/contactSubmission")
	// @CrossOrigin(origins = "http://localhost:3000")
	public ResponseEntity<List<ContactSubmission>> getAllContactSubmissions() {
		List<ContactSubmission> subs = new ArrayList<ContactSubmission>();
		HttpStatus status = HttpStatus.OK;
		try {
			subs = contactSubmissionService.getAllContactSubmissions();
		}
		catch (final Exception e) {
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
		}
		catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<ContactSubmission>(sub, status);
	}

	@PostMapping("/contactSubmission")
	@CrossOrigin(origins = { "http://localhost:3000", "108.36.194.240:3000", "http://jeffsweb.site/" })
	public ResponseEntity<NewContactSubmissionResponse> newContactSubmission(@RequestBody ContactSubmission sub) {
		HttpStatus status = HttpStatus.OK;
		final NewContactSubmissionResponse response = new NewContactSubmissionResponse();
		try {
			final String validationErrors = verifyContactSubmission(sub);
			if (!(validationErrors.equals(""))) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				response.setValidationMessage(validationErrors);

			}
			else {
				final SendMailResponse mailResponse = mailUtility.sendContactSubmissionEmail(sub);
				response.setMailResponse(mailResponse);
				if (mailResponse.isSuccess()) {
					sub = contactSubmissionService.saveContactSubmission(sub);
					response.setSubmission(sub);
					status = HttpStatus.OK;
				}
				else {
					status = HttpStatus.INTERNAL_SERVER_ERROR;
					response.setValidationMessage(mailResponse.getValidationMessage());
				}
			}
		}
		catch (final Exception e) {
			response.setValidationMessage(e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		response.setHttpStatus(status);
		return new ResponseEntity<NewContactSubmissionResponse>(response, status);
	}

	@DeleteMapping("/contactSubmission/{id}")
	@CrossOrigin(origins = { "http://localhost:3000", "108.36.194.240:3000", "http://jeffsweb.site/" })
	public ResponseEntity<Boolean> removeContactSubmission(@PathVariable("id") final int id) {
		HttpStatus status = HttpStatus.OK;
		Boolean deleted = true;
		try {
			if (!verifyId(id)) {
				throw new IllegalArgumentException();
			}
			contactSubmissionService.removeContactSubmission(id);
		}
		catch (final Exception e) {
			System.out.println(e);
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			deleted = false;
		}
		return new ResponseEntity<Boolean>(deleted, status);
	}

}
