package com.farmars.dto;

import org.springframework.stereotype.Component;

@Component
public class UserResponse {
		
	private String status;
	private String code;
	private String message;
	
	
	
	public String getStatus() {
		return status;
	}
	public String getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	
	
}
