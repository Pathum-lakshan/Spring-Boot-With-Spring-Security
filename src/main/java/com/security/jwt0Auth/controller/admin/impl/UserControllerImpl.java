package com.security.jwt0Auth.controller.admin.impl;

import com.security.jwt0Auth.controller.admin.UserController;
import com.security.jwt0Auth.dto.requests.admin.ChangePassword;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import com.security.jwt0Auth.service.admin.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 8:27 PM
 */

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Override
    public Response<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }

    @Override
    public Response<User> save(com.security.jwt0Auth.dto.requests.admin.User user) {
        return userService.save(user);
    }

    @Override
    public Response<Boolean> password(ChangePassword changePassword) {
        return userService.password(changePassword);
    }
}
