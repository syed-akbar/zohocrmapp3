package com.zoho.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImp implements EmailService {
	
	@Autowired
	private JavaMailSender javamailsender;

	@Override
	public String sendSimpleMail(String to, String sub, String text) {
		SimpleMailMessage mess = new SimpleMailMessage();
		mess.setTo(to);
		mess.setSubject(sub);
		mess.setText(text);
	
		javamailsender.send(mess);
		return null;
	}

}
