/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.controller;

import java.util.List;

import javax.annotation.Resource;

import com.murong.prepayment.common.dao.domain.TaskSchedule;
import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.facade.api.SchedulerFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调度Controller
 * @author lw.xu
 * @version $Id: SchedulerController.java, v 0.1 2017年8月31日 下午9:29:08 lw.xu Exp $
 */
@Controller
public class SchedulerController {

    private static final Logger logger         = LoggerFactory.getLogger(SchedulerController.class);

    private static final String SCHEDULER_LIST = "schedulerList";

    @Resource
    private SchedulerFacade     schedulerFacade;

    @GetMapping("scheduler/list")
    public String getSchedulerList(ModelMap modelMap) {
        LogUtil.info(logger, "收到获取调度任务列表请求");

        List<TaskSchedule> tasks = schedulerFacade.getAllTaskDetail();

        LogUtil.info(logger, "查询到调度任务数量:{0}", tasks.size());

        modelMap.put("tasks", tasks);
        modelMap.put("taskSize", tasks.size());

        return SCHEDULER_LIST;
    }

}
