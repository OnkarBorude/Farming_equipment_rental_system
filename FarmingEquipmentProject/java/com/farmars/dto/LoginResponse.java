package com.farmars.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
	
	private String status;
	private String code;
	private String message;
	
	public static LoginResponse getInstance() {
		return new LoginResponse();
	}

	public String getStatus() {
		return status;
	}

	public LoginResponse setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getCode() {
		return code;
	}

	public LoginResponse setCode(String code) {
		this.code = code;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public LoginResponse setMessage(String message) {
		this.message = message;
		return this;
	}
	
	
}
