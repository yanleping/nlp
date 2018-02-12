package com.nlp.app.rest;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.nlp.app.pojo.Article;
import com.nlp.app.similarity.ValueSave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("similarity")
public class NlpRest {
    @Autowired
    ValueSave valueSave;

    @RequestMapping("/detail")
    public String findArticleById(@RequestParam(required=true) Long id) {
        Article article = valueSave.getArticleById(id);
        return JSON.toJSONString(article);
    }

    @RequestMapping("/list")
    public String findList(@RequestParam(required=false,defaultValue="1") Integer pageNum,
                           @RequestParam(required=false,defaultValue="10")Integer pageSize){
        PageInfo<Article> pageInfo = valueSave.selectPage(pageNum,pageSize);
        return JSON.toJSONString(pageInfo);
    }

    @RequestMapping("/select")
    public String selectArticle(@RequestParam(required=true) String param){
        List<Article> article = valueSave.getArticleByAutOrTit(param);
        return JSON.toJSONString(article);
    }
}
