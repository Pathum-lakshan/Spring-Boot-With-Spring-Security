package com.security.jwt0Auth.dto.requests.admin;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-19 7:28 AM
 */

@Setter
@Getter
public class User {
    private String username, password;
}
