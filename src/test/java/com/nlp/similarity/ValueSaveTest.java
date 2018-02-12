package com.nlp.similarity;

import com.nlp.app.pojo.Article;
import com.nlp.app.similarity.ValueSave;
import com.nlp.app.util.SpringBeanUtil;
import com.nlp.config.Application;
import org.springframework.boot.SpringApplication;

public class ValueSaveTest {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ValueSave valueSave = (ValueSave) SpringBeanUtil.getBean("valueSave");

        Long id = new Long(2);
        Article article = valueSave.getArticleById(id);
        System.out.println(article.getDigest());
//      assertTrue(studentService.likeName("小明2").size() > 0);
    }

}