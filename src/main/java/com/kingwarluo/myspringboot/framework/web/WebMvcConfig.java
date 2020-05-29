package com.kingwarluo.myspringboot.framework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private MvcProperties mvcProperties;

    @Value("${spring.application.name}")
    private String name;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor interceptor = new LoginInterceptor();
        String noLoginUrls = mvcProperties.getNoLoginUrls();
        if(!StringUtils.isEmpty(noLoginUrls)) {
            String[] noLoginUrlArr = noLoginUrls.split(",");
            Set<String> noLoginUrlSet = new HashSet<String>();
            for (String string : noLoginUrlArr) {
                noLoginUrlSet.add(string);
            }
            interceptor.setNoLoginUrls(noLoginUrlSet);
        }
        registry.addInterceptor(interceptor);
    }
}
