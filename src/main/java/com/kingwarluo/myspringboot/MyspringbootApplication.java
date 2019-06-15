package com.kingwarluo.myspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @description:应用启动类
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@SpringBootApplication
//开启注解缓存
@EnableCaching
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}