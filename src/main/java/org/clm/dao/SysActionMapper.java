package org.clm.dao;

import org.clm.bean.SysAction;

public interface SysActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysAction record);

    int insertSelective(SysAction record);

    SysAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysAction record);

    int updateByPrimaryKey(SysAction record);
}