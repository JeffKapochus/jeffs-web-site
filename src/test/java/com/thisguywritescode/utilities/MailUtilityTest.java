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
public class MailUtilityTest {

	private ContactSubmission CONTACT_SUBMISSION;

	@Before
	public void setUp() {
		CONTACT_SUBMISSION = new ContactSubmission();
		CONTACT_SUBMISSION.setName("TestName");
		CONTACT_SUBMISSION.setEmail("fakeEmail@nothing.com");
		CONTACT_SUBMISSION.setSubject("Subject");
		CONTACT_SUBMISSION.setContent("Content");
		CONTACT_SUBMISSION.setCreated_at(new Date());
		CONTACT_SUBMISSION.setUpdated_at(new Date());
		CONTACT_SUBMISSION.setIsActive(true);
	}

	@Test
	public void SendContactSubmissionEmail_returnsFalse_whenGivenInvalidContactSubmission() {
		CONTACT_SUBMISSION.setName(null);

		assertThat(MailUtility.SendContactSubmissionEmail(CONTACT_SUBMISSION), is(false));
	}

	@Test
	public void SendContactSubmissionEmail_returnsTrue_whenGivenValidContactSubmission() {
		assertThat(MailUtility.SendContactSubmissionEmail(CONTACT_SUBMISSION), is(true));
	}

}
