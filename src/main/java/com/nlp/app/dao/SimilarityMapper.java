package com.nlp.app.dao;

import com.nlp.app.pojo.Similarity;

public interface SimilarityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Similarity record);

    int insertSelective(Similarity record);

    Similarity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Similarity record);

    int updateByPrimaryKey(Similarity record);
}