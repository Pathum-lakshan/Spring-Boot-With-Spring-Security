package com.security.jwt0Auth.service.admin.impl;

import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.Role;
import com.security.jwt0Auth.persistence.admin.Type;
import com.security.jwt0Auth.service.admin.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:12 AM
 */

@Service
public class RoleServiceImpl implements RoleService {
    @Override
    public Response<List<Role>> findAll(Integer pageSize, Integer pageNo) {
        return null;
    }

    @Override
    public Response<Role> save(String name, Type type) {
        return null;
    }

    @Override
    public Response<Boolean> delete(Long id) {
        return null;
    }
}
