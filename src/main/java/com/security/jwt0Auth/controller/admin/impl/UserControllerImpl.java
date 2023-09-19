package com.security.jwt0Auth.controller.admin.impl;

import com.security.jwt0Auth.controller.admin.UserController;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import com.security.jwt0Auth.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 8:27 PM
 */

@Controller
@RequestMapping("user")
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    //    @ApiOperation("Get a User by username")
    @Override
    public Response<User> findByUsername(String username) {
        return userService.findByUsername(username);
    }

    //    @ApiOperation("Save User")
    @Override
    public Response<User> save(com.security.jwt0Auth.dto.requests.user.User user) {
        return userService.save(user);
    }
}
