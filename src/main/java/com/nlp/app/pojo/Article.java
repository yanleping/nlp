package com.nlp.app.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class Article {
    private Long id;

    private Long wid;

    private String author;

    private String title;

    private String digest;

    private String content;

    private Integer wordCount;

    @JSONField(format="yyyy-MM-dd")
    private Date createTime;

    public Article(Long id, Long wid, String author, String title, String digest, String content, Integer wordCount, Date createTime) {
        this.id = id;
        this.wid = wid;
        this.author = author;
        this.title = title;
        this.digest = digest;
        this.content = content;
        this.wordCount = wordCount;
        this.createTime = createTime;
    }

    public Article() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWid() {
        return wid;
    }

    public void setWid(Long wid) {
        this.wid = wid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest == null ? null : digest.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getWordCount() {
        return wordCount;
    }

    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}