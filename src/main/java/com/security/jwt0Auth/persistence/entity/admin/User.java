package com.security.jwt0Auth.persistence.entity.admin;

import com.security.jwt0Auth.persistence.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 8:42 PM
 */

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User extends SuperEntity implements UserDetails {

    @Column(name = "username", length = 150, nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "active", nullable = false)
    private Boolean active = Boolean.FALSE;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Auth> auths;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (auths == null || auths.isEmpty()) return new ArrayList<>();
        return auths.stream().map(auth -> new SimpleGrantedAuthority(auth.getRole().getType().name())).collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return !getIsDeleted();
    }

    @Override
    public boolean isAccountNonLocked() {
        return getActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return getActive();
    }
}
