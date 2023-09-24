package com.security.jwt0Auth.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-19 6:57 AM
 */

@Getter
public class ServiceException extends RuntimeException {
    private final HttpStatus httpStatus;

    public ServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

}
