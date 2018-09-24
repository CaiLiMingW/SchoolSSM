package org.clm.dao;

import org.clm.bean.Ad;
import org.clm.dto.AdDto;

import java.util.List;

public interface AdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ad record);

    int insertSelective(Ad record);

    List<AdDto> selectByPrimaryKey(Ad ad);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}