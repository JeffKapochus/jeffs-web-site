package com.jeffswebsite.controllers;

import static com.jeffswebsite.utilities.Constants.SERVICE_SUCCESS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.jeffswebsite.models.StringResponse;

@RunWith(MockitoJUnitRunner.class)
public class StatusControllerTest {

	StatusController statusController;

	@Before
	public void setUp() {
		statusController = new StatusController();
	}

	@Test
	public void getStatus_returnsStatusOK_underNormalConditions() {
		final ResponseEntity<StringResponse> result = statusController.getStatus();

		assertThat(result.getBody().response, is(SERVICE_SUCCESS));
	}

}
