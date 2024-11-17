package com.farmars.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.farmars.dto.UserRequest;
import com.farmars.dto.UserResponse;
import com.farmars.encryption.EncryptionService;
import com.farmars.entity.Users;
import com.farmars.enums.EmailReply;
import com.farmars.enums.OtpReply;
import com.farmars.enums.UserReply;
import com.farmars.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class UserService {
	
	@Autowired
	UsersRepo usersRepo;
	
	@Autowired
	EncryptionService encryptionService;
	
	public UserResponse addUserss(UserRequest request) {
		UserResponse userResponse=UserResponse.getInstance();
		
			try {
				Users user = Users.getInstance().setFirstName(request.getFirstName())
						.setLastName(request.getLastName())
						.setEmail(request.getEmail())
						.setPassword(encryptionService.encrypt(request.getPassword()))
						.setPinCode(request.getPinCode())
						.setMobileNo(request.getMobileNo());
				
				String subject="Thanks for registering on Farmer I-Connect";
				 String body="Dear Sir/Madam"+"\n\n"+"Welcome "+request.getFirstName()+"\n\n"+"\tAs a farmer , choose a better way of farming. More economical, more environmental and human friendly"+
						 "\nAs a farmer, share your equipment ride with the community for more savings.\n";
				 String footer="\n\t\t\tBest regards,"+"\n"+"Farmer I-Connect";	
				 user=usersRepo.save(user);
				
				try {
					
					sendEmail(request.getEmail(), subject, body, footer);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					return userResponse.setCode(EmailReply.OTP_SENT_FAILED.getCode())
							.setStatus(EmailReply.OTP_SENT_FAILED.getStatus())
							.setMessage(EmailReply.OTP_SENT_FAILED.getMessege());
				}
				
			} catch (IllegalBlockSizeException e) {
				
				e.printStackTrace();
				return userResponse.setCode(UserReply.UNSUCCESSFUL.getCode())
						.setStatus(UserReply.UNSUCCESSFUL.getStatus())
						.setMessage(UserReply.UNSUCCESSFUL.getMessege());
			} catch (BadPaddingException e) {
				
				e.printStackTrace();
				return userResponse.setCode(UserReply.UNSUCCESSFUL.getCode())
						.setStatus(UserReply.UNSUCCESSFUL.getStatus())
						.setMessage(UserReply.UNSUCCESSFUL.getMessege());
			}
			
			return userResponse.setCode(UserReply.SUCCESSFUL.getCode())
					.setStatus(UserReply.SUCCESSFUL.getStatus())
					.setMessage(UserReply.SUCCESSFUL.getMessege());
			
			
		
			
		
//		else {
//			return userResponse.setCode(UserReply.UNSUCCESSFUL.getCode())
//					.setStatus(UserReply.UNSUCCESSFUL.getStatus())
//					.setMessage(UserReply.UNSUCCESSFUL.getMessege());
//			
//		}
		
		
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
