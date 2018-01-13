package com.murong.prepayment.common.dao;

import com.murong.prepayment.common.dao.domain.BizPayOrder;

public interface BizPayOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(BizPayOrder record);

    int insertSelective(BizPayOrder record);

    BizPayOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BizPayOrder record);

    int updateByPrimaryKey(BizPayOrder record);
}