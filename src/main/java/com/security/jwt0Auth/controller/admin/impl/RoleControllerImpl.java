package com.security.jwt0Auth.controller.admin.impl;

import com.security.jwt0Auth.controller.admin.RoleController;
import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.Role;
import com.security.jwt0Auth.persistence.entity.enums.admin.Type;
import com.security.jwt0Auth.service.admin.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:10 AM
 */

@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleService roleService;

    @Override
    public Response<List<Role>> findAll(Integer pageSize, Integer pageNo) {
        return roleService.findAll(pageSize, pageNo);
    }

    @Override
    public Response<Role> save(String name, Type type) {
        return roleService.save(name, type);
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return roleService.delete(id);
    }
}
