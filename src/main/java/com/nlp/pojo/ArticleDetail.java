package com.nlp.pojo;

public class ArticleDetail {
    private Long id;

    private String author;

    private String title;

    private String digest;

    private String content;

    private Integer cordcount;

    public ArticleDetail(Long id, String author, String title, String digest, String content, Integer cordcount) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.digest = digest;
        this.content = content;
        this.cordcount = cordcount;
    }

    public ArticleDetail() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}