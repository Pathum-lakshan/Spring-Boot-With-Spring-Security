package com.security.jwt0Auth.service.admin.impl;

import com.google.common.base.Strings;
import com.security.jwt0Auth.config.exception.ServiceException;
import com.security.jwt0Auth.dto.requests.admin.ChangePassword;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.User;
import com.security.jwt0Auth.persistence.repository.admin.UserRepo;
import com.security.jwt0Auth.service.admin.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

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
        return responseMapper(userMapper(findUserByUsername(username)), HttpStatus.OK, "Successfully Find User");
    }

    @Override
    public Response<User> save(com.security.jwt0Auth.dto.requests.admin.User user) {
        isExistsUser(user.getUsername());

        com.security.jwt0Auth.persistence.entity.admin.User userEntity =
                new com.security.jwt0Auth.persistence.entity.admin.User();

        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(encodePassword(user.getPassword()));
        userRepo.save(userEntity);

        return responseMapper(userMapper(userEntity), HttpStatus.CREATED, "Successfully Created User");
    }

    @Override
    public Response<Boolean> password(ChangePassword changePassword) {
        com.security.jwt0Auth.persistence.entity.admin.User user = findUserById(changePassword.getId());
        checkPreCondition(changePassword, user);
        user.setPassword(passwordEncoder.encode(changePassword.getNewPassword()));
        user.setUpdatedAt(LocalDateTime.now());
        userRepo.save(user);
        return responseMapper(Boolean.TRUE, HttpStatus.CREATED, "Successfully Change Password");
    }

    private void checkPreCondition(ChangePassword changePassword, com.security.jwt0Auth.persistence.entity.admin.User user) {
        if (!Objects.equals(changePassword.getUsername(), user.getUsername()))
            throw new ServiceException("Username Not Match", HttpStatus.PRECONDITION_FAILED);
        else if (!Objects.equals(passwordEncoder.encode(changePassword.getCurrentPassword()), user.getPassword()))
            throw new ServiceException("Current Password Not Match", HttpStatus.PRECONDITION_FAILED);
        else if (Objects.equals(passwordEncoder.encode(changePassword.getNewPassword()), user.getPassword())) {
            throw new ServiceException("New Password Is Equal Current Password", HttpStatus.PRECONDITION_FAILED);
        } else if (user.getActive() == null || !user.getActive()) {
            throw new ServiceException("Not Active User", HttpStatus.PRECONDITION_FAILED);
        }
    }

    private <T> Response<T> responseMapper(T t, HttpStatus httpStatus, String description) {
        return new Response<>(httpStatus, description, t);
    }

    private User userMapper(com.security.jwt0Auth.persistence.entity.admin.User user) {
        return mapper.map(user, User.class);
    }

    private void isExistsUser(String username) {
        if (Strings.isNullOrEmpty(username))
            throw new ServiceException("Username Is Empty", HttpStatus.PRECONDITION_FAILED);
        else if (userRepo.existsByUsernameIgnoreCaseAndIsDeletedIsFalse(username)) {
            throw new ServiceException("User Is Exists", HttpStatus.PRECONDITION_FAILED);
        }
    }

    private String encodePassword(String password) {
        if (Strings.isNullOrEmpty(password))
            throw new ServiceException("Password Is Empty", HttpStatus.PRECONDITION_FAILED);
        return passwordEncoder.encode(password);
    }

    private com.security.jwt0Auth.persistence.entity.admin.User findUserById(Long id) {
        return userRepo.findByIdAndIsDeletedIsFalse(id)
                .orElseThrow(() -> new ServiceException("User Not Found", HttpStatus.NOT_FOUND));
    }

    private com.security.jwt0Auth.persistence.entity.admin.User findUserByUsername(String username) {
        return userRepo.findByUsernameIgnoreCaseAndIsDeletedIsFalse(username)
                .orElseThrow(() -> new ServiceException("User Not Found", HttpStatus.NOT_FOUND));
    }

}
