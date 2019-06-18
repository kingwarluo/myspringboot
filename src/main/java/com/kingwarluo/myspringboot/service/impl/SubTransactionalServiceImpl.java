package com.kingwarluo.myspringboot.service.impl;

import com.kingwarluo.myspringboot.service.SubTransactionalService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:嵌套事务内部事务
 *
 * @author jianhua.luo
 * @date 2019/6/18
 */
@Service
public class SubTransactionalServiceImpl implements SubTransactionalService {

    /**
     * @description:内部嵌套事务（新建事务）
     *
     * @author jianhua.luo
     * @date 2019/6/18
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void innerRequiredNew() {

    }

    /**
     * @description:内部嵌套事务（嵌套事务）
     *
     * @author jianhua.luo
     * @date 2019/6/18
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.NESTED)
    public void innerNested() {

    }

}
