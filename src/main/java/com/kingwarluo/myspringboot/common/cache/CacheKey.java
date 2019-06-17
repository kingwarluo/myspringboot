package com.kingwarluo.myspringboot.common.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @description:缓存健（模块名：id）
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
//@Configuration
//@Component("key_gen")
@Slf4j
public class CacheKey implements KeyGenerator {

    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder sb = new StringBuilder();
//        sb.append(o.getClass().getSimpleName())
//                .append("_")
//                .append(method.getName())
//                .append("_")
//                .append(objects[0]);
//        log.info("cache_key:" + sb.toString());
        return sb.toString();
    }

}
