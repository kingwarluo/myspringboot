package com.kingwarluo.myspringboot.controller;

import com.kingwarluo.myspringboot.pojo.Person;
import com.kingwarluo.myspringboot.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:测试springCache
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@RestController
@RequestMapping("cache")
public class CacheTestController {

    @Autowired
    private CacheService cacheService;

    @RequestMapping("searchByPo")
    @ResponseBody
    public List<Person> searchByPo(Person person){
        return cacheService.searchByPo(person);
    }

    @RequestMapping("getById/{id}")
    @ResponseBody
    public Person getById(@PathVariable Long id) {
        return cacheService.getById(id);
    }

    @RequestMapping("insert")
    @ResponseBody
    public void insert(Long id, String name) {
        cacheService.insert(id, name);
    }

    @RequestMapping("deleteById/{id}")
    @ResponseBody
    public int deleteById(@PathVariable Long id) {
        return cacheService.deleteById(id);
    }
}