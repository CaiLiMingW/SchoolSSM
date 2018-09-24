package org.clm.dao;

import org.clm.bean.SysGroupAction;

public interface SysGroupActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysGroupAction record);

    int insertSelective(SysGroupAction record);

    SysGroupAction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysGroupAction record);

    int updateByPrimaryKey(SysGroupAction record);
}