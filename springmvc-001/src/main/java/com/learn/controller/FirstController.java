package com.learn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(path = "/second",method = {RequestMethod.GET, RequestMethod.POST})
    public String second() {
        return "second";}
}
