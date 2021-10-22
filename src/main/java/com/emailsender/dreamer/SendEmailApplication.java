package com.emailsender.dreamer;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@SpringBootApplication
public class SendEmailApplication {
	@Autowired
    private JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(SendEmailApplication.class, args);
	}
void sentMail() {
	SimpleMailMessage msg = new SimpleMailMessage();
    msg.setTo("email address to whom you send the mail");

    msg.setSubject("Testing from Spring Boot");
    msg.setText("Hello World \n Spring Boot Email");

    javaMailSender.send(msg);

}
void sendEmailWithAttachment() throws MessagingException, IOException {

    MimeMessage msg = javaMailSender.createMimeMessage();

    // true = multipart message
    MimeMessageHelper helper = new MimeMessageHelper(msg, true);

    helper.setTo("shailedrakushwaha1990@gmail.com");

    helper.setSubject("Testing from Spring Boot");

    // default = text/plain
    //helper.setText("Check attachment for image!");

    // true = text/html
    helper.setText("<h1>Check attachment for image!</h1>", true);

	// hard coded a file path
    FileSystemResource file = new FileSystemResource(new File("C:/Users\\1001018\\Desktop\\otp-13-min.png"));

    helper.addAttachment("otp-13-min.png", file);

    javaMailSender.send(msg);

}

}
