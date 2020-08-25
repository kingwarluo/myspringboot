package com.kingwarluo.myspringboot.biz.controller;

import com.kingwarluo.myspringboot.biz.domain.User;
import com.kingwarluo.myspringboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryAllUser")
    @ResponseBody
    public List<User> queryAllUser() {
        return userService.queryAllUser();
    }

    @RequestMapping(value = "updateById")
    public void getUserById(String name) {
        User user = new User();
        user.setId(1L);
        user.setName(name);
        user.setMobile("15659455896");

        userService.updateById(user);
    }

}
