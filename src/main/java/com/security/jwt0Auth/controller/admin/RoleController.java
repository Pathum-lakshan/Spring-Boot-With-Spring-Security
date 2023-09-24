package com.security.jwt0Auth.controller.admin;

import com.security.jwt0Auth.dto.response.Response;
import com.security.jwt0Auth.persistence.admin.Type;
import com.security.jwt0Auth.persistence.dto.admin.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-24 11:03 AM
 */


public interface RoleController {
    @GetMapping
    @ResponseBody
    Response<List<Role>> findAll(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                 @RequestParam(required = false, defaultValue = "0") Integer pageNo);

    @PostMapping
    @ResponseBody
    Response<Role> save(@RequestParam String name, @RequestParam Type type);

    @DeleteMapping
    @ResponseBody
    Response<Boolean> delete(@RequestParam Long id);

}
