package com.thisguywritescode.controllers;

import static com.thisguywritescode.utilities.Constants.SERVICE_SUCCESS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {

	StatusController statusController;

	@Before
	public void setUp() {
		statusController = new StatusController();
	}

	@Test
	public void getStatus_returnsStatusOK_underNormalConditions() {
		final ResponseEntity<String> expected = new ResponseEntity<String>(SERVICE_SUCCESS, HttpStatus.OK);
		final ResponseEntity<String> result = statusController.getStatus();

		assertThat(result, is(expected));
	}

}
