/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.quartz.job;

import com.murong.prepayment.common.util.LogUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 复杂任务
 * @author lw.xu
 * @version $Id: ComplexJob.java, v 0.1 2017年8月24日 下午3:56:02 lw.xu Exp $
 */
public class ComplexJob extends QuartzJobBean {

    private static final Logger logger = LoggerFactory.getLogger(ComplexJob.class);

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        LogUtil.info(logger, "log from ComplexJob");
    }

}
