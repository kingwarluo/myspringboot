package com.kingwarluo.myspringboot.framework.web;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 注入properties两种方法
 * 注意maven里，配置resources下.yml文件即可
 * 1、
     @Component
     @ConfigurationProperties(prefix = "app")
     属性在yml里将驼峰分割，用横线隔开，如no-login-urls
   2、
     @Configuration
     属性用@Value("${app.noLoginUrls}")注解，yml写上一样的属性即可
 * @author jianhua.luo
 * @date 2020/5/29
 */
@Data
@Component
@ConfigurationProperties(prefix = "app")
public class MvcProperties {

    private String noLoginUrls;

}
