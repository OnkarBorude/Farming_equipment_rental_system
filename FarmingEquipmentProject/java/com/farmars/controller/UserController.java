package com.farmars.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmars.dto.UserRequest;
import com.farmars.dto.UserResponse;
import com.farmars.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserService service;
	
	@PostMapping(path = "/api/farming/v1/adduser", 
			consumes = { "application/json","application/xml" }, 
			produces = { "application/json", "application/xml" })
	public UserResponse addUsers(@Valid @RequestBody UserRequest request) {
		return service.addUserss(request);
	}
	
}
