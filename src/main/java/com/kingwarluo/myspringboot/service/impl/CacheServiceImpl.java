package com.kingwarluo.myspringboot.service.impl;

import com.kingwarluo.myspringboot.pojo.Person;
import com.kingwarluo.myspringboot.service.CacheService;
import com.kingwarluo.myspringboot.util.RandomDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description:描述
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@Service
@Slf4j
public class CacheServiceImpl implements CacheService {

    private Map<Long, Person> map = new HashMap<Long, Person>();

    {
        map.put(1L, new Person(1L, "kingwarluo", RandomDateUtil.getRandomDate()));
        map.put(2L, new Person(2L, "kingwarluo2", RandomDateUtil.getRandomDate()));
        map.put(3L, new Person(3L, "kingwarluo3", RandomDateUtil.getRandomDate()));
        map.put(4L, new Person(4L, "kingwarluo4", RandomDateUtil.getRandomDate()));
        map.put(5L, new Person(5L, "kingwarluo5", RandomDateUtil.getRandomDate()));
        map.put(6L, new Person(6L, "kingwarluo6", RandomDateUtil.getRandomDate()));
    }

    @Override
    @Cacheable(keyGenerator = "key_gen", value = "person")
    public Person getById(Long id) {
        log.info("查找id=" + id);
        return map.get(id);
    }

    @Override
    @CachePut(cacheNames = "${id}", key = "#id")
    public void insert(Long id, String name) {
        map.put(id, new Person(id, name, RandomDateUtil.getRandomDate()));
    }

    @Override
    @CacheEvict(cacheNames = "${id}")
    public int deleteById(Long id) {
        if(map.containsKey(id)) {
            map.remove(id);
            return 1;
        }
        return 0;
    }

    @Override
    @CachePut(cacheNames = "")
    public List<Person> searchByPo(Person person) {
        log.info("search");
        List<Person> ret = new ArrayList<Person>();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Long key = (Long) it.next();
            ret.add(map.get(key));
        }
        return ret;
    }
}
