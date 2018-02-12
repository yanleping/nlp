package com.nlp.app.dao;

import com.nlp.app.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Long id);

    List<Article> selectArticleByAutOrTit(@Param("name") String name);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);

    List<Article> queryList(@Param("start") Integer start, @Param("pageSize") Integer pageSize);
}