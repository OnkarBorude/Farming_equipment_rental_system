package com.farmars.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
		
	private String status;
	private String code;
	private String message;
	
	public static UserResponse getInstance() {
		return new UserResponse();
	}

	public String getStatus() {
		return status;
	}

	public UserResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getCode() {
		return code;
	}

	public UserResponse setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public UserResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	
}
