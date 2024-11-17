package com.farmars.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.farmars.dto.OtpRequest;
import com.farmars.dto.UserResponse;
import com.farmars.service.NotificationService;

import jakarta.validation.Valid;

@RestController
public class OtpController {
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping(path = "api/farming/v1/otp",
			consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public UserResponse otpValidate(@Valid @RequestBody OtpRequest request) throws IOException
	{
		return notificationService.otpValidate(request);
	}
	
}
