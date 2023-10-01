package com.security.jwt0Auth.service.test.impl;

import com.security.jwt0Auth.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 8:02 PM
 */

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final JavaMailSender javaMailSender;

    @Override
    public String test() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("lakshanherath1101@gmail.com");
        message.setSubject("Test Email");
        message.setText("This is a test email sent from Spring Boot.");

        javaMailSender.send(message);
        return "OK";
    }

}
