package com.learnrest.controller;

import com.learnrest.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

/**
 * ClassName: UserController
 * Package: com.learnrest.controller
 * Description:
 */
@Controller
public class UserController {
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") String id) {
        System.out.println(id);
        return "ok";
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public String modifyUser(User user) throws UnsupportedEncodingException, FileNotFoundException {
        /*System.setOut(new PrintStream(System.out, true, "UTF-8"));
        System.out.println("Default Charset: " + Charset.defaultCharset());
        System.out.println("System Property file.encoding: " + System.getProperty("file.encoding"));
        System.out.println(new String("测试内容".getBytes(StandardCharsets.UTF_8)));
        System.out.println("你好世界");
        System.out.println("正在修改用户信息" + user);
        return "ok";*/
        PrintStream originalOut = System.out; // 保留原始输出流
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
            System.out.println("你好世界");
            System.out.println("正在修改用户信息：" + user);
        } finally {
            System.setOut(originalOut); // 恢复原始输出流
        }
        return "ok";
        /*try (PrintStream fileOut = new PrintStream("log.txt", "UTF-8")) {
            System.setOut(fileOut);
            System.out.println("你好世界");
            System.out.println("正在修改用户信息：" + user);
        }
        return "ok";*/
    }
}
