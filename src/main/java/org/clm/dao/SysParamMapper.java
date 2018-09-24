package org.clm.dao;

import org.clm.bean.SysParam;

public interface SysParamMapper {
    int insert(SysParam record);

    int insertSelective(SysParam record);
}