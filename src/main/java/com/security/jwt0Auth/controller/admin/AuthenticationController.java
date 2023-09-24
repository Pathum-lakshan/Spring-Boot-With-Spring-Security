package com.security.jwt0Auth.controller.admin;

import com.security.jwt0Auth.dto.requests.admin.User;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.dto.response.admin.Authenticate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 2:49 PM
 */

public interface AuthenticationController {
    @PostMapping
    @ResponseBody
    Response<Authenticate> authenticate(@RequestBody User user);
}
