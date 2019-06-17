package com.kingwarluo.myspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:用户
 *
 * Person类需要实现序列化接口，才能使用redis做缓存
 * @author jianhua.luo
 * @date 2019/6/15
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {

    private Long id;

    private String name;

    private Date birthday;

}
