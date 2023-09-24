package com.security.jwt0Auth.persistence.dto.admin;

import com.security.jwt0Auth.persistence.dto.SuperDTO;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:53 AM
 */

@Setter
@Getter
public class Auth extends SuperDTO {
    private Long user;
    private Long role;

}
