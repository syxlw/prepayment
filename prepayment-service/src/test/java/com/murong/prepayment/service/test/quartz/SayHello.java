/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.service.test.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

/**
 * 
 * @author lw.xu
 * @version $Id: SayHello.java, v 0.1 2017年8月21日 下午9:20:39 lw.xu Exp $
 */
public class SayHello implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("hello quartz! " + new Date() + " by " + context.getTrigger().getNextFireTime());

        JobKey key = context.getJobDetail().getKey();
        JobKey jobKey = context.getTrigger().getJobKey();
        System.out.println("job key from trigger : " + jobKey);

        JobDataMap mergedDataMap = context.getMergedJobDataMap();

        System.out.println("merged data map size = " + mergedDataMap.size());
        System.out.println(mergedDataMap.get("123") + ", " + mergedDataMap.getString("prepayment"));

        JobDataMap dataMap = context.getJobDetail().getJobDataMap();

        String strContent = dataMap.getString("prepayment");

        System.out.println("Instance " + key + "of job says: " + strContent);
    }
}
