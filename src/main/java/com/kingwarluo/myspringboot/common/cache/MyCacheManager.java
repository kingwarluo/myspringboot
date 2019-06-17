package com.kingwarluo.myspringboot.common.cache;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @description:自定义缓存，使用redis
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
//@Component
public class MyCacheManager implements CacheManager {

    @Override
    public Cache getCache(String s) {
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return null;
    }

}
