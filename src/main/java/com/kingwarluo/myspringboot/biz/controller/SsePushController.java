package com.kingwarluo.myspringboot.biz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 使用server sent event技术实时推送到客户端
 *
 * https://www.jianshu.com/p/b1f00785799c
 *
 * @author jianhua.luo
 * @date 2021/7/1
 */
@Controller
@Slf4j
public class SsePushController {

    @GetMapping(value = "/home")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/sse/pushMess")
    @ResponseBody
    public void pushMess(HttpServletResponse response) {
        log.info("开始推送消息");
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");
        int i = 0;
        while (true) {
            try {
                System.out.println("推送" + i++);
                Thread.sleep(1000L);
                String s = "event: specially\n";
                s += "data:" + i + "Testing 1,2,3------- "+new Date() +"\n\n";
                PrintWriter pw = response.getWriter();
                if(pw.checkError()) {
                    log.error("客户端关闭连接");
                    pw.close();
                    return ;
                }
                pw.write(s);
                pw.flush();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
