package com.security.jwt0Auth.dto.response.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-19 6:37 AM
 */

@Getter
@Setter
@AllArgsConstructor
public class Error {
    private Integer status;
    private String error;
    private String message;
    private String path;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    public Error(HttpStatus httpStatus, String message, String path, LocalDateTime timestamp) {
        this.status = httpStatus.value();
        this.error = httpStatus.getReasonPhrase();
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }
}
