package com.kingwarluo.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @description:应用启动类
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@SpringBootApplication
//开启注解缓存
@EnableCaching
//启用spring-session,30分钟过期
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 30 * 60 * 60)
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
