/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2018 All Rights Reserved.
 */
package com.murong.prepayment.web.mvc.service;

/**
 * 用户注册消息发送接口
 * @author lw.xu
 * @version $Id: UserRegisterMqProducerService.java, v 0.1 2018年1月11日 下午8:00:15 lw.xu Exp $
 */
public interface UserRegisterMqProducerService {

    /**
     * 发送注册消息
     * @throws Exception 
     */
    void process(long userId) throws Exception;

}
