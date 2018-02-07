package com.nlp.pojo;

import java.util.Date;

public class AticleDetail {
    private Integer id;

    private String author;

    private String title;

    private String digest;

    private String content;

    private Integer cordcount;

    private Date createtime;

    public AticleDetail(Integer id, String author, String title, String digest, String content, Integer cordcount, Date createtime) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.digest = digest;
        this.content = content;
        this.cordcount = cordcount;
        this.createtime = createtime;
    }

    public AticleDetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCordcount() {
        return cordcount;
    }

    public void setCordcount(Integer cordcount) {
        this.cordcount = cordcount;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}