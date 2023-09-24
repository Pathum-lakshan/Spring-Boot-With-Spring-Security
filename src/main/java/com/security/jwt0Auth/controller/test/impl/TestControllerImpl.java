package com.security.jwt0Auth.controller.test.impl;

import com.security.jwt0Auth.controller.test.TestController;
import com.security.jwt0Auth.service.test.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-14 7:56 PM
 */

@Controller
@RequestMapping("test")
@RequiredArgsConstructor
public class TestControllerImpl implements TestController {

    private final TestService testService;

    @Override
    public String test() {
        return testService.test();
    }

}
