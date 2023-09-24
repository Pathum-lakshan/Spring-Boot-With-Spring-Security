package com.security.jwt0Auth.persistence.entity.admin;

import com.security.jwt0Auth.persistence.entity.SuperEntity;
import com.security.jwt0Auth.persistence.entity.enums.admin.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 10:54 AM
 */

@Entity
@Setter
@Getter
@Table(name = "role")
public class Role extends SuperEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM ('USER', 'ADMIN') NOT NULL")
    private Type type;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<Auth> auths;
}
