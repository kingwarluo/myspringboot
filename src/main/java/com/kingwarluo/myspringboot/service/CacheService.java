package com.kingwarluo.myspringboot.service;

import com.kingwarluo.myspringboot.pojo.Person;

import java.util.List;

/**
 * @description:缓存测试service
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
public interface CacheService {

    public Person getById(Long id);

    public Person insert(Long id, String name);

    public int deleteById(Long id);

    public List<Person> searchByPo(Person person);

}
