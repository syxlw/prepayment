package com.murong.prepayment.common.dao;

import com.murong.prepayment.common.dao.domain.BizUserInfo;

public interface BizUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BizUserInfo record);

    int insertSelective(BizUserInfo record);

    BizUserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BizUserInfo record);

    int updateByPrimaryKey(BizUserInfo record);
}