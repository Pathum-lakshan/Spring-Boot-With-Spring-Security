package com.security.jwt0Auth.service.admin.impl;

import com.google.common.base.Strings;
import com.security.jwt0Auth.config.exception.ServiceException;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import com.security.jwt0Auth.persistence.repository.UserRepo;
import com.security.jwt0Auth.service.admin.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-18 11:00 PM
 */

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Response<User> findByUsername(String username) {
        if (Strings.isNullOrEmpty(username))
            throw new ServiceException("User Name Is Empty", HttpStatus.PRECONDITION_FAILED);

        Optional<com.security.jwt0Auth.persistence.entity.admin.User> optionalUser =
                userRepo.findByUsernameIgnoreCaseAndIsDeletedIsFalse(username);
        if (optionalUser.isEmpty())
            throw new ServiceException("User Not Found", HttpStatus.NOT_FOUND);

        return responseMapper(userMapper(optionalUser.get()), HttpStatus.OK, "Successfully Find User");
    }

    @Override
    public Response<User> save(com.security.jwt0Auth.dto.requests.user.User user) {
        if (Strings.isNullOrEmpty(user.getUsername()))
            throw new ServiceException("Username Is Empty", HttpStatus.PRECONDITION_FAILED);
        else if (Strings.isNullOrEmpty(user.getPassword()))
            throw new ServiceException("Password Is Empty", HttpStatus.PRECONDITION_FAILED);

        com.security.jwt0Auth.persistence.entity.admin.User userEntity =
                new com.security.jwt0Auth.persistence.entity.admin.User();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(passwordEncoder.encode(user.getPassword()));
        userEntity.setCreatedAt(LocalDateTime.now());
        userEntity.setUpdatedAt(LocalDateTime.now());
        userRepo.save(userEntity);

        return responseMapper(userMapper(userEntity), HttpStatus.CREATED, "Successfully Created User");
    }

    private <T> Response<T> responseMapper(T t, HttpStatus httpStatus, String description) {
        return new Response<>(httpStatus, description, t);
    }

    private User userMapper(com.security.jwt0Auth.persistence.entity.admin.User user) {
        return mapper.map(user, User.class);
    }

}
