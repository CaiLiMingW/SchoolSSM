package org.clm.dao;

import org.clm.bean.Dic;
import org.clm.bean.DicKey;

import java.util.List;

public interface DicMapper {
    int deleteByPrimaryKey(DicKey key);

    int insert(Dic record);

    int insertSelective(Dic record);

    List<Dic> select(String type);

    int updateByPrimaryKeySelective(Dic record);

    int updateByPrimaryKey(Dic record);
}