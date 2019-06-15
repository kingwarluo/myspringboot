package com.kingwarluo.myspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @description:用户
 *
 * @author jianhua.luo
 * @date 2019/6/15
 */
@Data
@AllArgsConstructor
public class Person {

    private Long id;

    private String name;

    private Date birthday;

}
