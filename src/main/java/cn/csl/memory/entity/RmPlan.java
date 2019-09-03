package cn.csl.memory.entity;

import java.util.Date;

public class RmPlan {
    private Long id;

    private Integer state;

    private Date createTime;

    private Integer vocNumber;

    private Long vocabularyId;

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

    public Integer getVocNumber() {
        return vocNumber;
    }

    public void setVocNumber(Integer vocNumber) {
        this.vocNumber = vocNumber;
    }

    public Long getVocabularyId() {
        return vocabularyId;
    }

    public void setVocabularyId(Long vocabularyId) {
        this.vocabularyId = vocabularyId;
    }
}