package com.kingwarluo.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

/**
 * @description:应用启动类
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@SpringBootApplication(
    exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class}
)
public class MyspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringbootApplication.class, args);
    }

}
