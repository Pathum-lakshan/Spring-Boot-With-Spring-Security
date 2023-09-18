package com.security.jwt0Auth.persistence.repository;

import com.security.jwt0Auth.persistence.entity.admin.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 10:47 PM
 */

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsernameIgnoreCase(String username);

}
