package com.kingwarluo.myspringboot.framework.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Set;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    private Set<String> noLoginUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        if(noLoginUrls.contains(url)) {
            log.info("不需要登录");
        } else {
            log.info("登录拦截器");
        }
        return true;
    }

    public void setNoLoginUrls(Set<String> noLoginUrls) {
        this.noLoginUrls = noLoginUrls;
    }
}
