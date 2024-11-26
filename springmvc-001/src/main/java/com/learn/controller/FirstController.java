package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: FirstController
 * Package: com.learn.controller
 * Description:
 *
 */
@Controller
public class FirstController {
    @RequestMapping("/first")
    public String first() {
        return "first";
    }

}
