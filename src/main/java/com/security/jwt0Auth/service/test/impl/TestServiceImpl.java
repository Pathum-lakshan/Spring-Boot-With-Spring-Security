package com.security.jwt0Auth.service.test.impl;

import com.security.jwt0Auth.service.test.TestService;
import org.springframework.stereotype.Service;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 8:02 PM
 */

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "OK";
    }

}
