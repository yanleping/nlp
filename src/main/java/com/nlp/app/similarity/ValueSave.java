package com.nlp.app.similarity;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.nlp.app.dao.ArticleMapper;
import com.nlp.app.dao.SimilarityMapper;
import com.nlp.app.pojo.Article;
import com.nlp.app.pojo.Similarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("valueSave")
public class ValueSave {
    private static Logger logger = LoggerFactory.getLogger(ValueSave.class);

    @Autowired
    private SimilarityMapper textSimilarityMapper;

    @Autowired
    private ArticleMapper articleDetailMapper;

    @Autowired
    SimilarityCount similarityCount;


    /**
     * 根据文本id获取文章信息
     * @param id
     * @return
     */

    public Article getArticleById(Long id){
        return articleDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据作者名或者文章标题模糊查询
     * @param name
     * @return
     */
    public List<Article> getArticleByAutOrTit(String name){
        name = "%"+name+"%";

        return articleDetailMapper.selectArticleByAutOrTit(name);
    }

    public PageInfo<Article> selectPage(Integer pageNo,Integer pageSize){
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);
        Integer start = (pageNo-1)*pageSize;
        List<Article> list = articleDetailMapper.queryList(start,pageSize);
        PageInfo pageInfo = new PageInfo(list);

        return pageInfo;
    }

    /**
     * 将两个文本之间的相似度信息保存到数据库
     * @param text1Id
     * @param text2Id
     */
    public void save(Long text1Id,Long text2Id){

        Article text1 = this.getArticleById(text1Id);
        Article text2 = this.getArticleById(text2Id);

        BigDecimal value = similarityCount.textSimilarty(text1.getContent(),text2.getContent());
        Similarity textSimilarity = new Similarity();
        textSimilarity.setCurrentWorkId(text1.getId());
        textSimilarity.setTargetWorkId(text2.getId());
        textSimilarity.setSimilarity(value);
        try {
            textSimilarityMapper.insert(textSimilarity);
        }catch(Exception e){
            logger.error("插入数据库失败");
        }
    }
}
