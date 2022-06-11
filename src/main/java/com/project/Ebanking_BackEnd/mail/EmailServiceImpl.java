package com.project.Ebanking_BackEnd.mail;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;


@Service("EmailService")
public class EmailServiceImpl  implements EmailService{
	 private static final String NOREPLY_ADDRESS = "kardadyassmin01@gmail.com";

	    @Autowired
	    private JavaMailSender emailSender;
	    
	    @Value("classpath:/mail-logo.png")
	    private Resource resourceFile;

	    public void sendSimpleMessage(String to, String pass) {
	        try {
	            SimpleMailMessage message = new SimpleMailMessage();
	            String newLine = System.getProperty("line.separator");

	            message.setFrom(NOREPLY_ADDRESS);
	            message.setTo(to);
	            message.setSubject("Confirmation Message | E-banking App");
	            message.setText(new StringBuilder()
    	                .append("Thank you for your registration")
    	                .append(newLine)
    	                .append("Here is your password "+pass)
    	                .append(newLine)
    	                .append("...")
    	                .toString());

	            emailSender.send(message);
	        } catch (MailException exception) {
	            exception.printStackTrace();
	        }
	    }

	    /*
	    @Override
	    public void sendMessageWithAttachment(String to,String pass) {
	        try {
	            MimeMessage message = emailSender.createMimeMessage();
	            // pass 'true' to the constructor to create a multipart message
	            MimeMessageHelper helper = new MimeMessageHelper(message, true);
	            String newLine = System.getProperty("line.separator");
	            helper.setFrom(NOREPLY_ADDRESS);
	            helper.setTo(to);
	            helper.setSubject("Confirmation Message | E-banking App");
	            helper.setText(new StringBuilder()
    	                .append("Thank you for your registration")
    	                .append(newLine)
    	                .append("Here is your password "+pass)
    	                .append(newLine)
    	                .append("...")
    	                .toString());

	            FileSystemResource file = new FileSystemResource(new File("classpath:/mail-logo.png"));
	            helper.addAttachment("Invoice", file);

	            emailSender.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }*/

	   
}
