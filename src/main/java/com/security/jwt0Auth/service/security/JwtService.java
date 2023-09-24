package com.security.jwt0Auth.service.security;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 12:51 PM
 */

public interface JwtService {
    String extractUserName(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(Map<String, Object> claims, UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
