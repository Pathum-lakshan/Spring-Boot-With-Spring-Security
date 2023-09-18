package com.security.jwt0Auth.service.admin;

import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 11:00 PM
 */

public interface UserService {
    Response<User> findByUsername(String username);
    Response<User> save(User user);
}
