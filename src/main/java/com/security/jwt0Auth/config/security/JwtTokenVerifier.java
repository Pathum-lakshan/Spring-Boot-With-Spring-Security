package com.security.jwt0Auth.config.security;

import com.google.common.base.Strings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.SneakyThrows;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-16 7:33 PM
 */

public class JwtTokenVerifier extends OncePerRequestFilter {
    @Override
    @SneakyThrows
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {
        String authorizationHeader=request.getHeader("Authorization");
        if (Strings.isNullOrEmpty(authorizationHeader)||authorizationHeader.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
            String token =authorizationHeader.replace("Bearer ","");
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey("seD5*5GGG#$8#$JHVj4323*(JHKJ8[kl,;lv43wi".getBytes())
                .parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String username = body.getSubject();
        var authorities= body.get("authorities");
    }
}
