package org.clm.dao;

import org.clm.bean.Business;
import org.clm.bean.SearcrBean;

import java.util.List;

public interface BusinessMapper {
    int delete(Integer id);

    int insert(Business record);

    int insertSelective(Business record);

    List<Business> select();

    List<Business> selectById(SearcrBean searcrBean);

    void update(Business record);

    void updateByPrimaryKey(Business record);
}