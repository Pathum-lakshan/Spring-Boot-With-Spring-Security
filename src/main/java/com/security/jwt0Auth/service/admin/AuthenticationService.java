package com.security.jwt0Auth.service.admin;

import com.security.jwt0Auth.dto.requests.admin.User;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.dto.response.admin.Authenticate;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 3:01 PM
 */

public interface AuthenticationService {
    Response<Authenticate> authenticate(User user);
}
