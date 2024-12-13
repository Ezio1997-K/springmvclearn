package com.usemymvc.controllers;

import org.myspringmvcdemo.stereotype.Controller;
import org.myspringmvcdemo.ui.ModelMap;
import org.myspringmvcdemo.web.bind.annotation.RequestMapping;
import org.myspringmvcdemo.web.bind.annotation.RequestMethod;

/**
 * ClassName: UserController
 * Package: com.usemymvc.controllers
 * Description:
 *
 */
@Controller
public class UserController {
    @RequestMapping(value = "/",requestMethod = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("user","李四");
        return "index";
    }
}
