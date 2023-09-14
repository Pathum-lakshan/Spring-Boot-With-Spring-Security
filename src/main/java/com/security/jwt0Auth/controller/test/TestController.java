package com.security.jwt0Auth.controller.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 7:55 PM
 */

public interface TestController {

    @GetMapping
    @ResponseBody
    String test();

}
