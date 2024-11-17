package com.farmars.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginRequest {
	
	@NotBlank(message = "Email  Cannot be blank")
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{4,8}(.)[a-z]{3,5}", message = "Please!,Enter the valid email format")
	private String email;
	
	@NotBlank(message = "passsword Cannot be blank")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
