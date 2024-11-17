package com.farmars.dto;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {
	
	@NotBlank(message = "First Name Cannot be blank")
	private String firstName;
	
	@NotBlank(message = "Last Name Cannot be blank")
	private String lastName;
	
	@Pattern(regexp = "[a-z0-9]{3,50}(@)[a-z]{4,8}(.)[a-z]{3,5}", message = "Please!,Enter the valid email format")
	private String email;
	
	@NotBlank(message = "password Cannot be blank")
	private String password;
	
	//@NotBlank(message = "First Name Cannot be blank")
	private int pinCode;
	
	//@NotBlank(message = "First Name Cannot be blank")
	private Long mobileNo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

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

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
