package com.security.jwt0Auth.service.setup.email;

import org.springframework.lang.Nullable;

import java.util.Date;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-10-04 9:16 AM
 */

public interface EmailService {
    void send(@Nullable
              String from,
              @Nullable
              String replyTo,
              @Nullable
              String[] to,
              @Nullable
              String[] cc,
              @Nullable
              String[] bcc,
              @Nullable
              String subject,
              @Nullable
              String text);
}
