package com.security.jwt0Auth.persistence.entity.admin;

import com.security.jwt0Auth.persistence.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:41 AM
 */

@Entity
@Setter
@Getter
@Table(name = "auth")
public class Auth extends SuperEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user", referencedColumnName = "id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role", referencedColumnName = "id")
    private Role role;

}
