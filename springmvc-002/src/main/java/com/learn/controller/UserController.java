package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName: UserController
 * Package: com.learn.controller
 * Description:
 *
 */
@Controller
public class UserController {
    @RequestMapping("/")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/regist")
    public String testRegister(@RequestParam("hobby") String interests) {
        System.out.println(interests);
        return "Hello";
    }
}
