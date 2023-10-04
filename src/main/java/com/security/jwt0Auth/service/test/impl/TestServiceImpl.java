package com.security.jwt0Auth.service.test.impl;

import com.security.jwt0Auth.service.setup.email.EmailService;
import com.security.jwt0Auth.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 8:02 PM
 */

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {


    private final EmailService emailService;

    @Override
    public String test() {
        emailService.send("Pathumlakshanherath@gmail.com", "Pathumlakshanherath@gmail.com",
                new String[]{"lakshanherath1101@gmail.com"}, new String[]{"pathuml@lassana.com", "sldarkgamersyt@gmail.com"}, null,
                "TEST EMAIL", "This is a test email sent from Spring Boot.");
        return "T E S T API OK WITH SENDED EMAIL    ";
    }

}
