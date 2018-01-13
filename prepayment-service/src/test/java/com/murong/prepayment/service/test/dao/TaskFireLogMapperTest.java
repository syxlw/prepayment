/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.test.dao;

import java.util.Date;

import javax.annotation.Resource;

import com.murong.prepayment.common.dao.TaskFireLogMapper;
import com.murong.prepayment.common.dao.domain.TaskFireLog;
import com.murong.prepayment.common.dao.domain.TaskFireLog.JOBSTATUS;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.service.test.BaseTest;
import com.murong.prepayment.service.util.NativeUtil;
import org.junit.Test;

/**
 * 
 * @author lw.xu
 * @version $Id: TaskFireLogMapperTest.java, v 0.1 2017年8月29日 下午8:13:34 lw.xu Exp $
 */
public class TaskFireLogMapperTest extends BaseTest {

    @Resource
    private TaskFireLogMapper taskFireLogMapper;

    @Test
    public void testInsertAndGetId() {
        TaskFireLog log = new TaskFireLog();
        log.setStartTime(new Date());
        log.setGroupName("group name");
        log.setTaskName("task name");
        log.setStatus(JOBSTATUS.INIT_STATUS);
        log.setServerHost(NativeUtil.getHostName());
        log.setServerDuid(NativeUtil.getDUID());

        taskFireLogMapper.insertAndGetId(log);

        Long id = log.getId();

        LogUtil.info(logger, "id = {0}", id);

    }
}
