package com.farmars.entity;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Integer id;

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String password;
	
	@Column
	private int pinCode;
	
	@Column
	private Long mobileNo;
	
	public static Users getInstance() {
		return new Users();
	}

	public Integer getId() {
		return id;
	}

	public Users setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getFirstName() {
		return firstName;
	}

	public Users setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public String getLastName() {
		return lastName;
	}

	public Users setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Users setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Users setPassword(String password) {
		this.password = password;
		return this;
	}

	public int getPinCode() {
		return pinCode;
	}

	public Users setPinCode(int pinCode) {
		this.pinCode = pinCode;
		return this;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public Users setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
		return this;
	}
	
	
	
	
	
}
