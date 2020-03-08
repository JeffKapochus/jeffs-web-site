package com.jeffswebsite.services;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.jeffswebsite.models.ContactSubmission;
import com.jeffswebsite.repositories.ContactSubmissionRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContactSubmissionServiceTests {

	@InjectMocks
	IContactSubmissionService contactSubmissionService = new ContactSubmissionService();

	@Mock
	ContactSubmissionRepository mockContactSubmissionRepository;

	@Mock
	ContactSubmission mockContactSubmission;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private final int VALID_CONTACT_SUBMISSION_ID = 1;
	private final String VALID_NAME = "Test Name";
	private final String VALID_EMAIL = "Jeff.Kapochus@gmail.com";
	private List<ContactSubmission> VALID_SUBMISSION_LIST;
	private List<ContactSubmission> EMPTY_SUBMISSION_LIST;

	@Before
	public void setUp() {
		EMPTY_SUBMISSION_LIST = new ArrayList<ContactSubmission>();

		VALID_SUBMISSION_LIST = new ArrayList<ContactSubmission>();
		VALID_SUBMISSION_LIST.add(mockContactSubmission);
		VALID_SUBMISSION_LIST.add(mockContactSubmission);
		VALID_SUBMISSION_LIST.add(mockContactSubmission);

		doReturn(Optional.of(mockContactSubmission)).when(mockContactSubmissionRepository)
				.findById(VALID_CONTACT_SUBMISSION_ID);
		doReturn(VALID_SUBMISSION_LIST).when(mockContactSubmissionRepository).findAll();
		doReturn(VALID_SUBMISSION_LIST).when(mockContactSubmissionRepository).findByName(VALID_NAME);
		doReturn(VALID_SUBMISSION_LIST).when(mockContactSubmissionRepository).findByEmail(VALID_EMAIL);
	}

	@Test
	public void getContactSubmissionById_returnsValidContactSubmission_whenGivenValidId() {
		assertThat(contactSubmissionService.getContactSubmissionById(VALID_CONTACT_SUBMISSION_ID),
				is(mockContactSubmission));
	}

	@Test
	public void getContactSubmissionById_returnsEmpty_whenGivenInvalidId() {
		assertThat(contactSubmissionService.getContactSubmissionById(0), is(nullValue()));
	}

	@Test
	public void getAllContactSubmissions_returnsValidSubmissionList_byDefault() {
		assertThat(contactSubmissionService.getAllContactSubmissions(), is(VALID_SUBMISSION_LIST));
	}

	@Test
	public void getAllContactSubmissions_returnsEmptyList_whenNoContactSubmissionsAreFound() {
		doReturn(EMPTY_SUBMISSION_LIST).when(mockContactSubmissionRepository).findAll();

		assertThat(contactSubmissionService.getAllContactSubmissions(), is(EMPTY_SUBMISSION_LIST));
	}

	@Test
	public void getContactSubmissionsByName_returnsValidContactSubmissionList_whenGivenValidName() {
		assertThat(contactSubmissionService.getContactSubmissionsByName(VALID_NAME), is(VALID_SUBMISSION_LIST));
	}

	@Test
	public void getContactSubmissionsByName_returnsEmptyContactSubmissionList_whenGivenInvalidName() {
		assertThat(contactSubmissionService.getContactSubmissionsByName(null), is(EMPTY_SUBMISSION_LIST));
	}

	@Test
	public void getContactSubmissionsByEmail_returnsValidContactSubmissionList_whenGivenValidEmail() {
		assertThat(contactSubmissionService.getContactSubmissionsByEmail(VALID_EMAIL), is(VALID_SUBMISSION_LIST));
	}

	@Test
	public void getContactSubmissionsByEmail_returnsEmptyContactSubmissionList_whenGivenInvalidEmail() {
		assertThat(contactSubmissionService.getContactSubmissionsByEmail(null), is(EMPTY_SUBMISSION_LIST));
	}

	@Test
	public void saveContactSubmission_savesContactSubmission_whenGivenValidContactSubmission() {
		contactSubmissionService.saveContactSubmission(mockContactSubmission);
		verify(mockContactSubmissionRepository, times(1)).save(mockContactSubmission);
	}

	@Test
	public void saveContactSubmission_throwsException_whenGivenNull() {
		contactSubmissionService.saveContactSubmission(null);
		verify(mockContactSubmissionRepository, times(1)).save(null);
	}

	@Test
	public void removeContactSubmission_throwsException() {
		contactSubmissionService.removeContactSubmission(VALID_CONTACT_SUBMISSION_ID);
		assertThat(mockContactSubmission.getIsActive(), is(false));
		verify(mockContactSubmissionRepository, times(1)).save(mockContactSubmission);
	}
}