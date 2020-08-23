package com.kingwarluo.myspringboot.biz.dao;

import com.kingwarluo.myspringboot.biz.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> queryAllUser();

}
