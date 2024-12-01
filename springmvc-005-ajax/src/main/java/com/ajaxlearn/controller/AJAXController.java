package com.ajaxlearn.controller;

import com.ajaxlearn.pojo.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * ClassName: AJAXController
 * Package: com.ajaxlearn.controller
 * Description:
 *
 */
@Controller
public class AJAXController {
    @RequestMapping(value = "/hello")
    public String hello(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello世界");
        return null;
    }
    /*@RequestMapping(value = "/hello")
    @ResponseBody
    public String hello() {
        return "hello世界";
    }*/
    @RequestMapping(value = "/sayHello")
    @ResponseBody
    public String sayHello(@RequestBody User user){
        System.out.println("file.encoding: " + System.getProperty("file.encoding"));
        System.out.println("sun.stdout.encoding: " + System.getProperty("sun.stdout.encoding"));
        System.out.println("sun.stderr.encoding: " + System.getProperty("sun.stderr.encoding"));
        System.out.println(user);
        return user.toString();
    }
}
