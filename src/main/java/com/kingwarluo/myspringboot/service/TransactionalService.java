package com.kingwarluo.myspringboot.service;

/**
 * @description:测试嵌套事务
 *
 * @author jianhua.luo
 * @date 2019/6/18
 */
public interface TransactionalService {

    public void outerRequiredAndInnerRequiredNew();

    public void outerRequiredAndInnerNested();

}
