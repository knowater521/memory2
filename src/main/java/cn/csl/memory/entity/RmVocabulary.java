package cn.csl.memory.entity;

import java.util.Date;

public class RmVocabulary {
    private Long id;

    private Integer state;

    private Date createTime;

    private String content;

    private String wrods;

    private Date memoryDate;

    private Integer memoryFlag;

    private Integer reviewNum;

    private Integer errorNum;

    private String exampleSentence;

    private String exampleSentenceTranslation;

    private String phonogram;

    private String imgUrl;

    private String rootTranslation;

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

    public String getWrods() {
        return wrods;
    }

    public void setWrods(String wrods) {
        this.wrods = wrods == null ? null : wrods.trim();
    }

    public Date getMemoryDate() {
        return memoryDate;
    }

    public void setMemoryDate(Date memoryDate) {
        this.memoryDate = memoryDate;
    }

    public Integer getMemoryFlag() {
        return memoryFlag;
    }

    public void setMemoryFlag(Integer memoryFlag) {
        this.memoryFlag = memoryFlag;
    }

    public Integer getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(Integer reviewNum) {
        this.reviewNum = reviewNum;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence == null ? null : exampleSentence.trim();
    }

    public String getExampleSentenceTranslation() {
        return exampleSentenceTranslation;
    }

    public void setExampleSentenceTranslation(String exampleSentenceTranslation) {
        this.exampleSentenceTranslation = exampleSentenceTranslation == null ? null : exampleSentenceTranslation.trim();
    }

    public String getPhonogram() {
        return phonogram;
    }

    public void setPhonogram(String phonogram) {
        this.phonogram = phonogram == null ? null : phonogram.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getRootTranslation() {
        return rootTranslation;
    }

    public void setRootTranslation(String rootTranslation) {
        this.rootTranslation = rootTranslation == null ? null : rootTranslation.trim();
    }
}