package cn.csl.memory.entity;

import java.util.Date;

public class RmTranslation {
    private Long id;

    private Integer state;

    private Date createTime;

    private Integer vocNumber;

    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}