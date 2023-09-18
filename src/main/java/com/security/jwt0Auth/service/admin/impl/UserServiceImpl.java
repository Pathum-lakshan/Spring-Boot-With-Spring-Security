package com.security.jwt0Auth.service.admin.impl;

import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import com.security.jwt0Auth.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 11:00 PM
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserService userService;

    @Autowired
    public UserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Response<User> findByUsername(String username) {

        return null;
    }

    @Override
    public Response<User> save(User user) {
        return null;
    }
}
