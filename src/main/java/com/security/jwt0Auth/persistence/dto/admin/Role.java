package com.security.jwt0Auth.persistence.dto.admin;

import com.security.jwt0Auth.persistence.dto.SuperDTO;
import com.security.jwt0Auth.persistence.admin.Type;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:02 AM
 */

@Setter
@Getter
public class Role extends SuperDTO {
    private String name;
    private Type type;
}
