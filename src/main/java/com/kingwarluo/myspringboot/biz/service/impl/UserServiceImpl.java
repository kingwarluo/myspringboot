package com.kingwarluo.myspringboot.biz.service.impl;

import com.kingwarluo.myspringboot.biz.dao.UserDao;
import com.kingwarluo.myspringboot.biz.domain.User;
import com.kingwarluo.myspringboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

}
