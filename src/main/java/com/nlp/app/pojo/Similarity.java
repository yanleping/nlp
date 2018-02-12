package com.nlp.app.pojo;

import java.math.BigDecimal;

public class Similarity {
    private Long id;

    private Long currentWorkId;

    private Long targetWorkId;

    private BigDecimal similarity;

    public Similarity(Long id, Long currentWorkId, Long targetWorkId, BigDecimal similarity) {
        this.id = id;
        this.currentWorkId = currentWorkId;
        this.targetWorkId = targetWorkId;
        this.similarity = similarity;
    }

    public Similarity() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCurrentWorkId() {
        return currentWorkId;
    }

    public void setCurrentWorkId(Long currentWorkId) {
        this.currentWorkId = currentWorkId;
    }

    public Long getTargetWorkId() {
        return targetWorkId;
    }

    public void setTargetWorkId(Long targetWorkId) {
        this.targetWorkId = targetWorkId;
    }

    public BigDecimal getSimilarity() {
        return similarity;
    }

    public void setSimilarity(BigDecimal similarity) {
        this.similarity = similarity;
    }
}