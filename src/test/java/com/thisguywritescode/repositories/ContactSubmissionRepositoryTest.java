package com.thisguywritescode.repositories;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.thisguywritescode.models.ContactSubmission;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ContactSubmissionRepositoryTest {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	ContactSubmissionRepository contactSubmissionRepository;

	private ContactSubmission contactSubmission;

	private List<ContactSubmission> resultList;

	private final String VALID_NAME = "Test Name";
	private final String VALID_EMAIL = "jeff.kapochus@gmail.com";
	private final String VALID_SUBJECT = "Test Subject";
	private final String VALID_CONTENT = "Test Content";

	@Before
	public void setUp() {
		contactSubmission = new ContactSubmission();
		contactSubmission.setName(VALID_NAME);
		contactSubmission.setEmail(VALID_EMAIL);
		contactSubmission.setSubject(VALID_SUBJECT);
		contactSubmission.setContent(VALID_CONTENT);

		resultList = new ArrayList<ContactSubmission>();
	}

	@Test
	public void setUp_hasProperlyInstantiated() {
		assertThat(contactSubmissionRepository, is(notNullValue()));
		assertThat(entityManager, is(notNullValue()));
	}

	@Test
	public void findByName_returnsListOfOne_whenDatabaseContainsOneMatch() {
		entityManager.persist(contactSubmission);
		resultList.add(contactSubmission);

		final List<ContactSubmission> result = contactSubmissionRepository.findByName(VALID_NAME);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByName_returnsListOfMany_whenDatabaseContainsMultipleMatches() {
		entityManager.persist(contactSubmission);
		resultList.add(contactSubmission);
		final ContactSubmission contactSubmissionTwo = new ContactSubmission();
		contactSubmissionTwo.setName(VALID_NAME);
		contactSubmissionTwo.setEmail(VALID_EMAIL);
		contactSubmissionTwo.setSubject(VALID_SUBJECT);
		contactSubmissionTwo.setContent(VALID_CONTENT);
		entityManager.persist(contactSubmissionTwo);
		resultList.add(contactSubmissionTwo);

		final List<ContactSubmission> result = contactSubmissionRepository.findByName(VALID_NAME);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByName_returnsEmptyList_whenDatabaseContainsNoMatches() {
		resultList = new ArrayList<ContactSubmission>();

		final List<ContactSubmission> result = contactSubmissionRepository.findByName(VALID_NAME);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByEmail_returnsListOfOne_whenDatabaseContainsOneMatch() {
		entityManager.persist(contactSubmission);
		resultList.add(contactSubmission);

		final List<ContactSubmission> result = contactSubmissionRepository.findByEmail(VALID_EMAIL);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByEmail_returnsListOfMany_whenDatabaseContainsMultipleMatches() {
		entityManager.persist(contactSubmission);
		resultList.add(contactSubmission);
		final ContactSubmission contactSubmissionTwo = new ContactSubmission();
		contactSubmissionTwo.setName(VALID_NAME);
		contactSubmissionTwo.setEmail(VALID_EMAIL);
		contactSubmissionTwo.setSubject(VALID_SUBJECT);
		contactSubmissionTwo.setContent(VALID_CONTENT);
		entityManager.persist(contactSubmissionTwo);
		resultList.add(contactSubmissionTwo);

		final List<ContactSubmission> result = contactSubmissionRepository.findByEmail(VALID_EMAIL);
		assertThat(result, is(resultList));
	}

	@Test
	public void findByEmail_returnsEmptyList_whenDatabaseContainsNoMatches() {
		resultList = new ArrayList<ContactSubmission>();

		final List<ContactSubmission> result = contactSubmissionRepository.findByEmail(VALID_EMAIL);
		assertThat(result, is(resultList));
	}

	@After
	public void tearDown() {
		entityManager.clear();
	}

}
