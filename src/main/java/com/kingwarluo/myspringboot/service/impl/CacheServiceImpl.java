package com.kingwarluo.myspringboot.service.impl;

import com.kingwarluo.myspringboot.pojo.Person;
import com.kingwarluo.myspringboot.service.CacheService;
import com.kingwarluo.myspringboot.util.RandomDateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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

    /**
     * @Cacheable:添加缓存
     * cacheNames/value:指定添加的缓存名称
     * keyGenerator:指定key生成策略
     * condition:缓存添加的条件，condition = "#a0>1"，第一个参数大于1时添加缓存
     * unless:当unless指定的条件为true时，方法的返回值就不会被缓存，unless = "#a0==2"，当第一个参数等于2时，方法返回值不会被缓存
     * @param id
     * @return
     */
    @Override
    @Cacheable(value = "person", key = "#id")
    public Person getById(Long id) {
        log.info("查找id=" + id);
        return map.get(id);
    }

    /**
     * @CachePut: 既调用方法，又更新缓存数据，同步更新缓存
     * 修改了数据库的某个数据，同时更新缓存
     * 运行时机：
     *     1、先调用目标方法
     *     2、将目标方法的结果缓存起来
     *
     * 测试步骤：
     * @param id
     * @param name
     */
    @Override
    @CachePut(value = "person", key = "#id")
    public Person insert(Long id, String name) {
        Person person = new Person(id, name, RandomDateUtil.getRandomDate());
        map.put(id, person);
        return person;
    }

    /**
     * @CacheEvict: 缓存清除
     * cacheNames/value:执行要删除的缓存名称
     * key:指定要清除的数据
     * beforeInvocation:是否在方法执行前执行
     *     beforeInvocation=false，在方法执行后执行，发生异常就不会删除缓存
     *     beforeInvocation=true，在方法执行前执行，不管方法是否异常，先删除缓存
     * allEntries = true:指定清除这个缓存中所有数据
     * @param id
     * @return
     */
    @Override
    @CacheEvict(value = "person", beforeInvocation = true, key = "#id")
    public int deleteById(Long id) {
        if(map.containsKey(id)) {
            map.remove(id);
            return 1;
        }
        return 0;
    }

    /**
     * @Caching:按指定规则缓存
     * @param person
     * @return
     */
    @Override
    @Caching(
        cacheable = {
            @Cacheable()
        },
        put = {
            @CachePut()
        },
        evict = {
            @CacheEvict()
        }
    )
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
