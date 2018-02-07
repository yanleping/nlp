package com.nlp.dao;

import com.nlp.pojo.AticleDetail;

public interface AticleDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AticleDetail record);

    int insertSelective(AticleDetail record);

    AticleDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AticleDetail record);

    int updateByPrimaryKey(AticleDetail record);
}