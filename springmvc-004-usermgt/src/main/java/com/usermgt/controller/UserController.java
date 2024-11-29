package com.usermgt.controller;

import com.usermgt.bean.User;
import com.usermgt.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * ClassName: UserController
 * Package: com.usermgt.controller
 * Description:
 *
 */
@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String listUsers(Model model) {
        List<User> users = userDao.selectAll();
        model.addAttribute("users", users);
        return "user_list";
    }
    @RequestMapping(path = "/user",method = RequestMethod.POST)
    public String addUser(User user) {
        userDao.insert(user);
        return "redirect:/user";
    }

    @RequestMapping(path = "/user/{id}",method = RequestMethod.GET )
    public String selectUser(@PathVariable("id") Long id, Model model) {
        User user = userDao.selectById(id);
        model.addAttribute("user", user);
        return "user_edit";
    }

    @RequestMapping(path = "/user",method = RequestMethod.PUT)
    public String modifyUser(User user){
        userDao.update(user);
        return "redirect:/user";
    }
    @DeleteMapping("/user/{id}")
    public String del(@PathVariable("id") Long id){
        // 删除
        userDao.deleteById(id);
        // 重定向
        return "redirect:/user";
    }

}
