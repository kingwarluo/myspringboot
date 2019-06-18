package com.kingwarluo.myspringboot.service.impl;

import com.kingwarluo.myspringboot.service.SubTransactionalService;
import com.kingwarluo.myspringboot.service.TransactionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:测试嵌套事务
 *
 * @author jianhua.luo
 * @date 2019/6/18
 */
@Service
public class TransactionalServiceimpl implements TransactionalService {

    @Autowired
    private SubTransactionalService subService;

    /**
     * @description:外部required内部required_new
     *
     * @author jianhua.luo
     * @date 2019/6/18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void outerRequiredAndInnerRequiredNew() {

    }

    /**
     * @description:外部required内部nested
     *
     * @author jianhua.luo
     * @date 2019/6/18
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void outerRequiredAndInnerNested() {

    }

}
