package com.jeffswebsite.controllers;

import static com.jeffswebsite.utilities.Constants.SERVICE_SUCCESS;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.jeffswebsite.models.StringResponse;

@Component
@Controller("statusController")
public class StatusController {
	@GetMapping(value = "/")
	@CrossOrigin(origins = { "http://localhost:3000", "108.36.194.240:3000", "http://jeffsweb.site" })
	public ResponseEntity<StringResponse> getStatus() {
		return new ResponseEntity<StringResponse>(new StringResponse(SERVICE_SUCCESS), HttpStatus.OK);
	}
}
