package com.security.jwt0Auth.controller.admin.impl;

import com.security.jwt0Auth.controller.admin.AuthenticationController;
import com.security.jwt0Auth.dto.requests.admin.User;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.dto.response.admin.Authenticate;
import com.security.jwt0Auth.service.admin.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 2:50 PM
 */

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {
    private final AuthenticationService authenticationService;

    @Override
    public Response<Authenticate> authenticate(User user) {
        return authenticationService.authenticate(user);
    }
}
