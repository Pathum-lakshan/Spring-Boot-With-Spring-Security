package com.security.jwt0Auth.controller.admin;

import com.security.jwt0Auth.dto.requests.user.ChangePassword;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 8:26 PM
 */

public interface UserController {

    @GetMapping
    @ResponseBody
    Response<User> findByUsername(@RequestParam String username);

    @PostMapping
    @ResponseBody
    Response<User> save(@RequestBody com.security.jwt0Auth.dto.requests.user.User user);

    @PutMapping("password")
    @ResponseBody
    Response<Boolean> password(@RequestBody ChangePassword changePassword);

}
