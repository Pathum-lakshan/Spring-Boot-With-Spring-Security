package com.security.jwt0Auth.persistence.entity.admin;

import com.security.jwt0Auth.persistence.entity.SuperEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 8:42 PM
 */

@Entity
@Setter
@Getter
@Table(name = "user")
public class User extends SuperEntity {

    @Column(name = "username", length = 150, nullable = false, unique = true)
    private String username;

    @Column(name = "password", length = 16, nullable = false)
    private String password;

}
