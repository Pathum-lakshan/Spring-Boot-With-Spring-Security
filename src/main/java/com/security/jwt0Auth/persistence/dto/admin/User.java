package com.security.jwt0Auth.persistence.dto.admin;

import com.security.jwt0Auth.persistence.dto.SuperDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 10:45 PM
 */

@Setter
@Getter
public class User extends SuperDTO {
    private String username;
}
