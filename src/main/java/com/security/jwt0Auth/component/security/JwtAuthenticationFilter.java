package com.security.jwt0Auth.component.security;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.security.jwt0Auth.component.gson.LocalDateTimeAdapter;
import com.security.jwt0Auth.config.exception.ServiceException;
import com.security.jwt0Auth.dto.response.error.Error;
import com.security.jwt0Auth.service.security.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.time.LocalDateTime;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 12:36 PM
 */

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    @SneakyThrows
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) {
        try {
            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userName;
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                filterChain.doFilter(request, response);
                return;
            }
            jwt = authHeader.substring(7);
            userName = jwtService.extractUserName(jwt);
            if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
                if (jwtService.isTokenValid(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } else throw new ServiceException("Invalid Token", HttpStatus.UNAUTHORIZED);
            } else throw new ServiceException("Missing or Invalid Token", HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            sendError(response, request, ex.getMessage());
        }
    }

    @SneakyThrows
    private void sendError(HttpServletResponse response, HttpServletRequest request, String message) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(gson.toJson(new Error(HttpStatus.PRECONDITION_FAILED, message, request.getContextPath(),
                LocalDateTime.now())));
    }
}
