package com.kingwarluo.myspringboot.biz.service.impl;

import com.kingwarluo.myspringboot.biz.dao.UserDao;
import com.kingwarluo.myspringboot.biz.domain.User;
import com.kingwarluo.myspringboot.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }

    /**
     * 测试事务，是生效的
     * @param user
     * @return
     */
    @Override
    @Transactional
    public int updateById(User user) {
        userDao.updateById(user);
        if(user.getName().equals("h")){
            throw new RuntimeException("aaa");
        }
        return 1;
    }

}
