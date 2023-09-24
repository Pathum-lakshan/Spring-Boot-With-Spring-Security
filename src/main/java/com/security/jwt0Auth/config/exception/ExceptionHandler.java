package com.security.jwt0Auth.config.exception;

import com.security.jwt0Auth.dto.response.error.Error;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-19 6:42 AM
 */

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Slf4j
public class ExceptionHandler extends ResponseEntityExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(java.lang.Exception.class)
    public ResponseEntity<Error> handleGlobalException(java.lang.Exception ex, WebRequest request) {
        LOGG.error(ex.getMessage(), ex);
        Error error = new Error(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(ServiceException.class)
    public ResponseEntity<Error> handleServiceException(ServiceException ex, WebRequest request) {
        Error error = new Error(
                ex.getHttpStatus(),
                ex.getMessage(),
                request.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, ex.getHttpStatus());
    }

}
