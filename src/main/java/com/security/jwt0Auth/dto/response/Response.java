package com.security.jwt0Auth.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 10:51 PM
 */

@Getter
@Setter
public class Response<T> {
    private Integer status;
    private String message;
    private String description;
    private T t;
}
