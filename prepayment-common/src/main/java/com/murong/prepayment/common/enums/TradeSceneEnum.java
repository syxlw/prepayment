/**
 * 深圳金融电子结算中心
 * Copyright (c) 1995-2017 All Rights Reserved.
 */
package com.murong.prepayment.common.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 交易场景枚举
 * @author lw.xu
 * @version $Id: TradeSceneEnum.java, v 0.1 2017年8月19日 下午5:07:17 lw.xu Exp $
 */
public enum TradeSceneEnum {

    bar_code("bar_code", "条码支付"),

    scan_code("scan_code", "扫码支付"),

    ;

    /** 枚举代码 */
    private String code;

    /** 枚举值 */
    private String desc;

    private TradeSceneEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**

     * 根据代码获取枚举，如果code对应的枚举不存在，则返回null

     * @param code 枚举代码

     * @return     对应的枚举对象

     */
    public static TradeSceneEnum getByCode(String code) {
        for (TradeSceneEnum eachValue : TradeSceneEnum.values()) {
            if (StringUtils.equals(code, eachValue.getCode())) {
                return eachValue;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
