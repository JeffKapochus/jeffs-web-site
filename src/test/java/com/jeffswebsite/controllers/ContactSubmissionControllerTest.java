package com.jeffswebsite.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jeffswebsite.models.ContactSubmission;
import com.jeffswebsite.services.ContactSubmissionService;

@RunWith(MockitoJUnitRunner.class)
public class ContactSubmissionControllerTest {

	@InjectMocks
	ContactSubmissionController contactSubmissionController;

	@Mock
	ContactSubmissionService mockContactSubmissionService;

	private ContactSubmission VALID_SUBMISSION;
	private final int VALID_ID = 1;
	private List<ContactSubmission> EMPTY_LIST;

	@Before
	public void setUp() {
		EMPTY_LIST = new ArrayList<ContactSubmission>();

		VALID_SUBMISSION = new ContactSubmission();
		VALID_SUBMISSION.setName("Jeff Kapochus");
		VALID_SUBMISSION.setEmail("jeff.kapochus@gmail.com");
		VALID_SUBMISSION.setSubject("Subject");
		VALID_SUBMISSION.setContent("Content");
		VALID_SUBMISSION.setCreated_at(new Date());
		VALID_SUBMISSION.setUpdated_at(new Date());
		VALID_SUBMISSION.setIsActive(true);

		doReturn(VALID_SUBMISSION).when(mockContactSubmissionService).saveContactSubmission(VALID_SUBMISSION);
	}

	@Test
	public void getAllContactSubmissions_returnsEmptyList_whenNoSubmissionsArePersisted() {
		doReturn(EMPTY_LIST).when(mockContactSubmissionService).getAllContactSubmissions();

		final ResponseEntity<List<ContactSubmission>> expected = new ResponseEntity<List<ContactSubmission>>(EMPTY_LIST,
				HttpStatus.OK);
		final ResponseEntity<List<ContactSubmission>> result = contactSubmissionController.getAllContactSubmissions();

		assertThat(result, is(expected));
	}

	@Test
	public void getAllContactSubmissions_returnsInternalServerError_whenContactSubmissionServiceFails() {
		doThrow(new NullPointerException()).when(mockContactSubmissionService).getAllContactSubmissions();

		final ResponseEntity<List<ContactSubmission>> expected = new ResponseEntity<List<ContactSubmission>>(EMPTY_LIST,
				HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<List<ContactSubmission>> result = contactSubmissionController.getAllContactSubmissions();

		assertThat(result, is(expected));
	}

	@Test
	public void getContactSubmissionById_returnsNull_whenNoSubmissionsArePersisted() {
		doReturn(null).when(mockContactSubmissionService).getContactSubmissionById(VALID_ID);

		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(
				(ContactSubmission) null, HttpStatus.OK);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController.getContactSubmissionById(VALID_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getContactSubmissionById_returnsInternalServerError_whenContactSubmissionServiceFails() {
		doThrow(new NullPointerException()).when(mockContactSubmissionService).getContactSubmissionById(VALID_ID);

		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(
				(ContactSubmission) null, HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController.getContactSubmissionById(VALID_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void getContactSubmissionById_returnsInternalServerError_whenGivenInvalidId() {
		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(
				(ContactSubmission) null, HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController.getContactSubmissionById(0);

		assertThat(result, is(expected));
	}

	@Test
	public void newContactSubmission_returnsInternalServerError_whenGivenInvalidSubmission() {
		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(
				(ContactSubmission) null, HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController.newContactSubmission(null);

		assertThat(result, is(expected));
	}

	@Test
	public void newContactSubmission_returnsInternalServerError_whenGivenIncompleteSubmission() {
		VALID_SUBMISSION.setName(null);

		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(VALID_SUBMISSION,
				HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController
				.newContactSubmission(VALID_SUBMISSION);

		assertThat(result, is(expected));
	}

	@Test
	public void newContactSubmission_savesSubmission_whenGivenValidSubmission() {
		final ResponseEntity<ContactSubmission> expected = new ResponseEntity<ContactSubmission>(VALID_SUBMISSION,
				HttpStatus.OK);
		final ResponseEntity<ContactSubmission> result = contactSubmissionController
				.newContactSubmission(VALID_SUBMISSION);

		assertThat(result, is(expected));
	}

	@Test
	public void removeContactSubmission_returnsTrue_whenGivenValidId() {
		final ResponseEntity<Boolean> expected = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		final ResponseEntity<Boolean> result = contactSubmissionController.removeContactSubmission(VALID_ID);

		assertThat(result, is(expected));
	}

	@Test
	public void removeContactSubmission_returnsInternalServerError_whenGivenInvalidId() {
		final ResponseEntity<Boolean> expected = new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		final ResponseEntity<Boolean> result = contactSubmissionController.removeContactSubmission(0);

		assertThat(result, is(expected));
	}

}
