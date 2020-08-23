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
    public List<User> queryAllUser(Long id) {
        return userService.queryAllUser();
    }

    @RequestMapping("getUserById")
    public User getUserById(Long id) {
        return new User();
    }

}
