package com.nlp.app.similarity;

import com.nlp.app.dao.ArticleDetailMapper;
import com.nlp.app.dao.TextSimilarityMapper;
import com.nlp.app.pojo.ArticleDetail;
import com.nlp.app.pojo.TextSimilarity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

public class ValueSave {
    private static Logger logger = LoggerFactory.getLogger(ValueSave.class);

    @Autowired
    private TextSimilarityMapper textSimilarityMapper;

    @Autowired
    private ArticleDetailMapper articleDetailMapper;

    @Autowired
    SimilarityCount similarityCount;


    /**
     * 根据文本id获取文章信息
     * @param id
     * @return
     */
    public ArticleDetail getArticleById(Long id){
        return articleDetailMapper.selectByPrimaryKey(id);
    }

    /**
     * 将两个文本之间的相似度信息保存到数据库
     * @param text1Id
     * @param text2Id
     */
    public void save(Long text1Id,Long text2Id){

        ArticleDetail text1 = this.getArticleById(text1Id);
        ArticleDetail text2 = this.getArticleById(text2Id);

        BigDecimal value = similarityCount.textSimilarty(text1.getContent(),text2.getContent());
        TextSimilarity textSimilarity = new TextSimilarity();
        textSimilarity.setText1Id(text1.getId());
        textSimilarity.setText2Id(text2.getId());
        textSimilarity.setSimilarityvalue(value);
        try {
            textSimilarityMapper.insert(textSimilarity);
        }catch(Exception e){
            logger.error("插入数据库失败");
        }
    }
}
