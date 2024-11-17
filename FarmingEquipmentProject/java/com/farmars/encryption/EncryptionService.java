package com.farmars.encryption;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

@Component
public class EncryptionService {
	
	private static final String SECRET_KEY="5F270B0EF2F0BAB8123A810368B0E4HS";
	private static final String ALGORITHM="AES";
	
	private static SecretKey secretKey;
	private static Cipher cipher;
	
	static {
		secretKey=new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8),ALGORITHM);
		try {
			cipher=Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		public static String encrypt(String data) throws IllegalBlockSizeException, BadPaddingException {
			byte[] encryptedData=cipher.doFinal(data.getBytes());
			return Base64.getEncoder().encodeToString(encryptedData);
			
		}
		
		public static String decrypt(String data) throws IllegalBlockSizeException, BadPaddingException {
			byte[] decrptedData=cipher.doFinal(Base64.getDecoder().decode(data));
			
			return new String(decrptedData, StandardCharsets.UTF_8);
		}
		
		public static SecretKey genrateAESKey() throws NoSuchAlgorithmException{
			KeyGenerator keyGenerator=KeyGenerator.getInstance(ALGORITHM);
			keyGenerator.init(256);
			return keyGenerator.generateKey();
		}
		
	}
	
	
