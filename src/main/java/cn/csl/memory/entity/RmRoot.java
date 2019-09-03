package cn.csl.memory.entity;

import java.util.Date;

public class RmRoot {
    private Long id;

    private Integer state;

    private Date createTime;

    private String content;

    private String translation;

    private Integer vocNumber;

    private String exampleVocabulary;

    private String exampleVocabularyTranslation;

    private String imgUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation == null ? null : translation.trim();
    }

    public Integer getVocNumber() {
        return vocNumber;
    }

    public void setVocNumber(Integer vocNumber) {
        this.vocNumber = vocNumber;
    }

    public String getExampleVocabulary() {
        return exampleVocabulary;
    }

    public void setExampleVocabulary(String exampleVocabulary) {
        this.exampleVocabulary = exampleVocabulary == null ? null : exampleVocabulary.trim();
    }

    public String getExampleVocabularyTranslation() {
        return exampleVocabularyTranslation;
    }

    public void setExampleVocabularyTranslation(String exampleVocabularyTranslation) {
        this.exampleVocabularyTranslation = exampleVocabularyTranslation == null ? null : exampleVocabularyTranslation.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }
}