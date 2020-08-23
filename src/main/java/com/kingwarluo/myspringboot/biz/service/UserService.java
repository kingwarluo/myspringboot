package com.kingwarluo.myspringboot.biz.service;

import com.kingwarluo.myspringboot.biz.domain.User;

import java.util.List;

public interface UserService {
    List<User> queryAllUser();
}
