package com.security.jwt0Auth.dto.requests.admin;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-21 9:55 AM
 */

@Setter
@Getter
public class ChangePassword {
    private Long id;
    private String username, newPassword, currentPassword;
}
