/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package org.prepayment.web.test.dubbo;

import java.util.List;

import javax.annotation.Resource;

import com.murong.prepayment.common.dao.domain.TaskSchedule;
import com.murong.prepayment.facade.api.SchedulerFacade;
import org.prepayment.web.test.base.BaseTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * 测试dubbo调用
 * @author lw.xu
 * @version $Id: SchedulerFacadeTest.java, v 0.1 2017年8月31日 下午9:16:07 lw.xu Exp $
 */
public class SchedulerFacadeTest extends BaseTest {

    @Resource
    private SchedulerFacade schedulerFacade;

    @Test
    public void testGetAllTaskDetail() {
        Assert.assertNotNull(schedulerFacade);
        List<TaskSchedule> ret = schedulerFacade.getAllTaskDetail();

        Assert.assertTrue(ret.size() > 0);
    }

}
