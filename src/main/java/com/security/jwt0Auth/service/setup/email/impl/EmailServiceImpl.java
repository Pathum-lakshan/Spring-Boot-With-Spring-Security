package com.security.jwt0Auth.service.setup.email.impl;

import com.security.jwt0Auth.service.setup.email.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-10-04 9:16 AM
 */

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    @Override
    public void send(String from, String replyTo, String[] to, String[] cc,
                     String[] bcc, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setReplyTo(replyTo);
        message.setTo(to);
        message.setCc(cc);
        message.setBcc(bcc);
        message.setSentDate(new Date());
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
}
