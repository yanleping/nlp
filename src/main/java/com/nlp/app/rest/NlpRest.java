package com.nlp.app.rest;

import com.alibaba.fastjson.JSON;
import com.nlp.app.pojo.Article;
import com.nlp.app.similarity.ValueSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("similarity")
public class NlpRest {
    @Autowired
    ValueSave valueSave;

    @RequestMapping("/findById")
    public String findArticleById(Long id) {
        Article article = valueSave.getArticleById(id);
        return JSON.toJSONString(article);
    }
}
