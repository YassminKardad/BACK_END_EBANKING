package com.project.Ebanking_BackEnd.mail;
import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;



public interface EmailService {
	 void sendSimpleMessage(String to,
             String pass);
	
	
	//void sendMessageWithAttachment(String to, String pass);
	
	
	
}
