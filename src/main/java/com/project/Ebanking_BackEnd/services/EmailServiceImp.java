package com.project.Ebanking_BackEnd.services;

import javax.mail.internet.MimeMessage;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import ch.qos.logback.classic.Logger;


@Component
public class EmailServiceImp {
	 @Autowired
	 private JavaMailSender javaMailSender;

	 public void sendEmail(String pass, String dest) {
		 System.out.println("Sending email ... ");
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(dest);
	        String newLine = System.getProperty("line.separator");
	       // char[] password = generatePassword();

	        String subject= new StringBuilder()
	                .append("Thank you for your registration")
	                .append(newLine)
	                .append("Here is your password "+pass)
	                .append(newLine)
	                .append("...")
	                .toString(); 
	        
	        msg.setSubject("Confirmation Message | E-banking App");
	        msg.setText(subject);
	        //msg .setTLS(true);
	        try {
				javaMailSender.send(msg);
				System.out.println("email sent !!! ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	
	 
	 public void sendCode(String pass, String dest) {
		 System.out.println("Sending Code ... ");
	        SimpleMailMessage msg = new SimpleMailMessage();
	        msg.setTo(dest);
	        String newLine = System.getProperty("line.separator");
	       // char[] password = generatePassword();

	        String subject= new StringBuilder()
	                .append("Hello !!!!!!!")
	                .append(newLine)
	                .append("Here is the code  "+pass)
	                .append(newLine)
	                .append("...")
	                .toString(); 
	        
	        msg.setSubject(" Message | E-banking App");
	        msg.setText(subject);
	        //msg .setTLS(true);
	        try {
				javaMailSender.send(msg);
				System.out.println("email sent !!! ");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }	
	/* private final JavaMailSender javaMailSender;

	    private static final Logger log = (Logger) LoggerFactory.getLogger(EmailServiceImp.class);

	    @Autowired
	    public EmailServiceImp (JavaMailSender javaMailSender) {
	        this.javaMailSender = javaMailSender;
	    }


	    @Override
	    public void send (String password,String receiver, String sender) {
	        MimeMessagePreparator preparator = new MimeMessagePreparator() {
	            @Override
	            public void prepare (MimeMessage mimeMessage) throws Exception {
	                MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
	                messageHelper.setTo(receiver);
	                messageHelper.setFrom(sender);
	                messageHelper.setSubject("Confirmation Message | E-banking App");
	    	        String newLine = System.getProperty("line.separator");

	                
	                messageHelper.setText(new StringBuilder()
	    	                .append("Thank you for your registration")
	    	                .append(newLine)
	    	                .append("Here is your password "+password)
	    	                .append(newLine)
	    	                .append("...")
	    	                .toString());
	            }
	        };
	        this.javaMailSender.send(preparator);
	    }
	    */
	   

}
