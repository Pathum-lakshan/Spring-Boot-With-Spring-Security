package com.security.jwt0Auth.service.admin.impl;

import com.security.jwt0Auth.dto.requests.admin.User;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.dto.response.admin.Authenticate;
import com.security.jwt0Auth.persistence.repository.admin.UserRepo;
import com.security.jwt0Auth.service.admin.AuthenticationService;
import com.security.jwt0Auth.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 3:02 PM
 */

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepo userRepo;
    private final JwtService jwtService;

    @Override
    public Response<Authenticate> authenticate(User user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        com.security.jwt0Auth.persistence.entity.admin.User userDao =
                userRepo.findByUsernameIgnoreCaseAndIsDeletedIsFalseAndActiveIsTrue(user.getUsername()).orElseThrow(() -> new BadCredentialsException("User Not Found"));
        String token = jwtService.generateToken(new HashMap<>(), userDao);

        return new Response<>(HttpStatus.OK, "Authorized", Authenticate.builder().token(token).build());
    }
}
