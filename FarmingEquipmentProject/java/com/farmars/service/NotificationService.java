package com.farmars.service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.farmars.dto.OtpRequest;
import com.farmars.dto.UserResponse;
import com.farmars.entity.Users;
import com.farmars.enums.OtpReply;
import com.farmars.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;

import com.farmars.repository.UsersRepo;

@Service
public class NotificationService {
	
		@Autowired
		UsersRepo repo;
		
		public UserResponse otpValidate(OtpRequest request) throws IOException
		{
			UserResponse responce=UserResponse.getInstance();
			Optional<Users> user=repo.findByEmail(request.getEmail());
			if(user.isPresent())
			{
				int otp=new Random().nextInt(900000)+100000;
				String subject=otp+" OTP for login";
				String body="Dear customer, use this One Time Password "+otp+" to log in to your Farmer I-Connect account. "
						+ "This OTP will be valid for the next 5 mins.";
				String footer="Best regards,\n Farmer I-Connect";
				sendEmail(request.getEmail(), subject, body, footer);
				return responce.setCode(OtpReply.OTP_SENT_SUCCESS.getCode())
						.setStatus(OtpReply.OTP_SENT_SUCCESS.getStatus())
						.setMessage(OtpReply.OTP_SENT_SUCCESS.getMessage());
						
			}
			else
			{
				return responce.setCode(OtpReply.OTP_SENT_FAILED.getCode())
						.setStatus(OtpReply.OTP_SENT_FAILED.getStatus())
						.setMessage(OtpReply.OTP_SENT_FAILED.getMessage());
						
			}
		}
		private void sendEmail(String recipientEmail, String subject, String body, String footer) throws IOException {
	        try {
	            Properties properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("application.config"));

	            Session session = Session.getInstance(properties, new Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(properties.getProperty("email.sender.address"),
	                            properties.getProperty("email.sender.password"));
	                }
	            });

	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(properties.getProperty("email.sender.address")));
	            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
	            message.setSubject(subject);

	            // Clean body and footer
	            body = cleanString(body);
	            footer = cleanString(footer);

	            // Set email content
	            message.setText(body + "\n" + footer);
	            Transport.send(message);

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }

	    private String cleanString(String inputStr) {
	        // Remove leading and trailing whitespace
	        inputStr = inputStr.trim();
	        // Remove control characters
	        inputStr = inputStr.replaceAll("[\\p{Cntrl}&&[^\r\n\t]]", "");
	        return inputStr;
	    }
	}


