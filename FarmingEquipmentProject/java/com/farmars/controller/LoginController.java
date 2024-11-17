package com.farmars.controller;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmars.dto.LoginRequest;
import com.farmars.dto.LoginResponse;
import com.farmars.service.LoginService;

import jakarta.validation.Valid;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@PostMapping(path = "/api/farming/v1/login", 
			consumes = { "application/json","application/xml" }, 
			produces = { "application/json", "application/xml" })
	public LoginResponse logins(@Valid @RequestBody LoginRequest loginRequest) throws IllegalBlockSizeException, BadPaddingException {
		return loginService.login(loginRequest);
	}
	
}
