/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service.impl;

import com.murong.prepayment.common.util.LogUtil;
import com.murong.prepayment.web.mvc.service.UserRegisterMqProducerService;
import com.murong.prepayment.web.mvc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户服务接口实现类
 * @author lw.xu
 * @version $Id: UserServiceImpl.java, v 0.1 2018年1月11日 下午7:27:05 lw.xu Exp $
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger           logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserRegisterMqProducerService userRegisterMqProducerService;

    @Override
    public boolean register(String name) {
        long userId = geneUserId();

        LogUtil.info(logger, "收到用户注册请求,name={0},userId={1}", name, userId);

        try {
            userRegisterMqProducerService.process(userId);
        } catch (Exception e) {
            logger.error("", e);
            return false;
        }

        return true;
    }

    /**
     * 生成用户Id
     * @return
     */
    private long geneUserId() {
        return System.currentTimeMillis();
    }
}
