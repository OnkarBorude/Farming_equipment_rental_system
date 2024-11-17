package com.farmars.dto;

import org.springframework.stereotype.Component;

@Component
public class OtpRequest {
	
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
