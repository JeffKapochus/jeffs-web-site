package com.thisguywritescode.utilities;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.thisguywritescode.models.ContactSubmission;

@RunWith(MockitoJUnitRunner.class)
public class FunctionsTest {

	private final int VALID_ID = 1;
	private final int NEGATIVE_INT = -1;
	private final int ZERO_INT = 0;
	private ContactSubmission CONTACT_SUBMISSION;

	@Before
	public void setUp() {
		CONTACT_SUBMISSION = new ContactSubmission();
		CONTACT_SUBMISSION.setName("Jeff Kapochus");
		CONTACT_SUBMISSION.setEmail("jeff.kapochus@gmail.com");
		CONTACT_SUBMISSION.setSubject("Subject");
		CONTACT_SUBMISSION.setContent("Content");
		CONTACT_SUBMISSION.setCreated_at(new Date());
		CONTACT_SUBMISSION.setUpdated_at(new Date());
		CONTACT_SUBMISSION.setIsActive(true);
	}

	@Test
	public void verifyId_returnsTrue_whenIntegerIsPositive() {
		assertThat(Functions.verifyId(VALID_ID), is(true));
	}

	@Test
	public void verifyId_returnsFalse_whenIntegerIsNegative() {
		assertThat(Functions.verifyId(NEGATIVE_INT), is(false));
	}

	@Test
	public void verifyId_returnsFalse_whenIntegerIsZero() {
		assertThat(Functions.verifyId(ZERO_INT), is(false));
	}

	@Test
	public void verifyId_returnsTrue_whenIntegerIsMax() {
		assertThat(Functions.verifyId(Integer.MAX_VALUE), is(true));
	}

	@Test
	public void verifyId_returnsFalse_whenIntegerIsMin() {
		assertThat(Functions.verifyId(Integer.MIN_VALUE), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsTrue_whenContactSubmissionIsComplete() {
		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(true));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionIsMissingName() {
		CONTACT_SUBMISSION.setName(null);

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionNameIsBlank() {
		CONTACT_SUBMISSION.setName("");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionNameIsEmpty() {
		CONTACT_SUBMISSION.setName(" ");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionIsMissingEmail() {
		CONTACT_SUBMISSION.setEmail(null);

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionEmailIsBlank() {
		CONTACT_SUBMISSION.setEmail("");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionEmailIsEmpty() {
		CONTACT_SUBMISSION.setEmail(" ");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionIsMissingSubject() {
		CONTACT_SUBMISSION.setSubject(null);

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionSubjectIsBlank() {
		CONTACT_SUBMISSION.setSubject("");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionSubjectIsEmpty() {
		CONTACT_SUBMISSION.setSubject(" ");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionIsMissingContent() {
		CONTACT_SUBMISSION.setContent(null);

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionContentIsBlank() {
		CONTACT_SUBMISSION.setContent("");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionContentIsEmpty() {
		CONTACT_SUBMISSION.setContent(" ");

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void verifyContactSubmission_returnsFalse_whenContactSubmissionIsNull() {
		CONTACT_SUBMISSION = null;

		assertThat(Functions.verifyContactSubmission(CONTACT_SUBMISSION), is(false));
	}

}
