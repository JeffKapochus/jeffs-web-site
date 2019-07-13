package com.thisguywritescode.models;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class ContactSubmissionTest {

	private final String VALID_STRING = "test string";
	private ContactSubmission contactSubmission;
	private final Date VALID_DATE = new Date();

	@Before
	public void SetUp() {
		contactSubmission = new ContactSubmission();
	}

	@Test
	public void contactSubmissionGetId_returnsZeroForNewObject() {
		assertThat(contactSubmission.getId(), is(0));
	}

	@Test
	public void contactSubmissionSetName_appropriatelySetsName() {
		contactSubmission.setName(VALID_STRING);
		assertThat(contactSubmission.getName(), is(VALID_STRING));
	}

	@Test
	public void contactSubmissionSetEmail_appropriatelySetsEmail() {
		contactSubmission.setEmail(VALID_STRING);
		assertThat(contactSubmission.getEmail(), is(VALID_STRING));
	}

	@Test
	public void contactSubmissionSetSubject_appropriatelySetsEmail() {
		contactSubmission.setSubject(VALID_STRING);
		assertThat(contactSubmission.getSubject(), is(VALID_STRING));
	}

	@Test
	public void contactSubmissionSetContent_appropriatelySetsEmail() {
		contactSubmission.setContent(VALID_STRING);
		assertThat(contactSubmission.getContent(), is(VALID_STRING));
	}

	@Test
	public void contactSubmissionSetCreated_at_appropriatelySetsCreated_at() {
		contactSubmission.setCreated_at(VALID_DATE);
		assertThat(contactSubmission.getCreated_at(), is(VALID_DATE));
	}

	@Test
	public void contactSubmissionSetUpdated_at_appropriatelySetsUpdated_at() {
		contactSubmission.setUpdated_at(VALID_DATE);
		assertThat(contactSubmission.getUpdated_at(), is(VALID_DATE));
	}

	@Test
	public void contactSubmissionSetIsActive_appropriatelySetsIsActive_whenGivenTrue() {
		contactSubmission.setIsActive(true);
		assertThat(contactSubmission.getIsActive(), is(true));
	}

	@Test
	public void contactSubmissionSetIsActive_appropriatelySetsIsActive_whenGivenFalse() {
		contactSubmission.setIsActive(false);
		assertThat(contactSubmission.getIsActive(), is(false));
	}

}
