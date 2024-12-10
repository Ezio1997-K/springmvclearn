package com.learnsource.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: UserController
 * Package: com.learnsource.controllers
 * Description:
 *
 */
@Controller
public class UserController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
