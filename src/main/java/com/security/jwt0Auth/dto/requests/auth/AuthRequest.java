package com.security.jwt0Auth.dto.requests.auth;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-16 6:28 PM
 */

@Getter
@Setter
public class AuthRequest {
    private String username;
    private String password;
}
