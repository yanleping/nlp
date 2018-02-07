package com.nlp.app.pojo;

import java.math.BigDecimal;

public class TextSimilarity {
    private Long id;

    private Long text1Id;

    private Long text2Id;

    private BigDecimal similarityvalue;

    public TextSimilarity(Long id, Long text1Id, Long text2Id, BigDecimal similarityvalue) {
        this.id = id;
        this.text1Id = text1Id;
        this.text2Id = text2Id;
        this.similarityvalue = similarityvalue;
    }

    public TextSimilarity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getText1Id() {
        return text1Id;
    }

    public void setText1Id(Long text1Id) {
        this.text1Id = text1Id;
    }

    public Long getText2Id() {
        return text2Id;
    }

    public void setText2Id(Long text2Id) {
        this.text2Id = text2Id;
    }

    public BigDecimal getSimilarityvalue() {
        return similarityvalue;
    }

    public void setSimilarityvalue(BigDecimal similarityvalue) {
        this.similarityvalue = similarityvalue;
    }
}