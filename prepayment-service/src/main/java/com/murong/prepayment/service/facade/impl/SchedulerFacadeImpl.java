/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.facade.impl;

import com.murong.prepayment.common.dao.TaskFireLogMapper;
import com.murong.prepayment.common.dao.domain.TaskFireLog;
import com.murong.prepayment.common.dao.domain.TaskSchedule;
import com.murong.prepayment.facade.api.SchedulerFacade;
import com.murong.prepayment.service.support.scheduler.SchedulerManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 调度门面接口实现类
 * @author lw.xu
 * @version $Id: SchedulerFacadeImpl.java, v 0.1 2017年8月30日 下午8:40:33 lw.xu Exp $
 */
@Service("schedulerFacade")
public class SchedulerFacadeImpl implements SchedulerFacade {

    private static final Logger logger = LoggerFactory.getLogger(SchedulerFacadeImpl.class);

    @Resource
    SchedulerManager            schedulerManager;

    @Resource
    private TaskFireLogMapper   taskFireLogMapper;

    @Override
    public List<TaskSchedule> getAllTaskDetail() {
        return schedulerManager.getAllJobDetail();
    }

    @Override
    public void execTask(TaskSchedule taskSchedule) {
        schedulerManager.runJob(taskSchedule);
    }

    @Override
    public void resumeTask(TaskSchedule taskSchedule) {
        schedulerManager.resumeJob(taskSchedule);
    }

    @Override
    public void stopTask(TaskSchedule taskSchedule) {
        schedulerManager.stopJob(taskSchedule);
    }

    @Override
    public void delTask(TaskSchedule taskSchedule) {
        schedulerManager.delJob(taskSchedule);
    }

    @Override
    public void addOrUpdateTask(TaskSchedule taskSchedule) {
        schedulerManager.addTask(taskSchedule);
    }

    @Override
    public List<TaskFireLog> queryFireLog() {
        //TODO
        return null;
    }

}
