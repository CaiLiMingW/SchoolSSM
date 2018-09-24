package org.clm.dao;

import org.clm.bean.SysGroupMenu;

public interface SysGroupMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysGroupMenu record);

    int insertSelective(SysGroupMenu record);

    SysGroupMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysGroupMenu record);

    int updateByPrimaryKey(SysGroupMenu record);
}