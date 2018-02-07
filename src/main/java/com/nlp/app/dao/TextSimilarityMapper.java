package com.nlp.app.dao;

import com.nlp.app.pojo.TextSimilarity;

public interface TextSimilarityMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TextSimilarity record);

    int insertSelective(TextSimilarity record);

    TextSimilarity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TextSimilarity record);

    int updateByPrimaryKey(TextSimilarity record);
}