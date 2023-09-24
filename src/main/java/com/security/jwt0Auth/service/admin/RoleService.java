package com.security.jwt0Auth.service.admin;

import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.dto.admin.Role;
import com.security.jwt0Auth.persistence.entity.enums.admin.Type;

import java.util.List;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:11 AM
 */

public interface RoleService {
    Response<List<Role>> findAll(Integer pageSize, Integer pageNo);

    Response<Role> save(String name, Type type);

    Response<Boolean> delete(Long id);

}
