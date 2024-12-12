package com.usemymvc.controllers;

import org.myspringmvcdemo.stereotype.Controller;
import org.myspringmvcdemo.web.bind.annotation.RequestMapping;
import org.myspringmvcdemo.web.bind.annotation.RequestMethod;

/**
 * ClassName: OrderController
 * Package: com.usemymvc.controllers
 * Description:
 *
 */
@Controller
public class OrderController {
    @RequestMapping(value = "/detail", requestMethod = RequestMethod.GET)
    public String orderDetail(){
        return "index";

    }
}