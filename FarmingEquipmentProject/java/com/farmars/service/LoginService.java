package com.farmars.service;

import java.util.Optional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmars.dto.LoginRequest;
import com.farmars.dto.LoginResponse;
import com.farmars.encryption.EncryptionService;
import com.farmars.entity.Users;
import com.farmars.enums.LoginReply;
import com.farmars.repository.UsersRepo;

@Service
public class LoginService {
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	EncryptionService encryptionService;
	
	public LoginResponse login(LoginRequest loginRequest) throws IllegalBlockSizeException, BadPaddingException {
		
		LoginResponse loginResponse=LoginResponse.getInstance();
		
		Optional<Users> user=usersRepo.findByEmailAndPassword(loginRequest.getEmail(),encryptionService.encrypt( loginRequest.getPassword()));
		
		if(user.isPresent()) {
			
			loginResponse.setCode(LoginReply.SUCCESSFUL.getCode())
				.setStatus(LoginReply.SUCCESSFUL.getStatus())
				.setMessage(LoginReply.SUCCESSFUL.getMessege());
			
			return loginResponse;
		}
		else {
			
			loginResponse.setCode(LoginReply.LOGIN_UNSUCCESSFUL.getCode())
				.setStatus(LoginReply.LOGIN_UNSUCCESSFUL.getStatus())
				.setMessage(LoginReply.LOGIN_UNSUCCESSFUL.getMessege());
			
			return loginResponse;
		}
		
	}
	
}
