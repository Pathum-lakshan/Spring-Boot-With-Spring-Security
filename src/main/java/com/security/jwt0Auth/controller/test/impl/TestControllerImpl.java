package com.security.jwt0Auth.controller.test.impl;

import com.security.jwt0Auth.controller.test.TestController;
import com.security.jwt0Auth.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 7:56 PM
 */

@Controller
@RequestMapping("test")
public class TestControllerImpl implements TestController {

    @Autowired
    private TestService testService;

    @Override
    public String test() {
        return testService.test();
    }

}
