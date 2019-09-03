package cn.csl.memory.entity;

import java.util.Date;

public class RmActivity {
    private Long id;

    private Integer state;

    private Date createTime;

    private Date startTime;

    private Date endTime;

    private Integer vocNumber;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getVocNumber() {
        return vocNumber;
    }

    public void setVocNumber(Integer vocNumber) {
        this.vocNumber = vocNumber;
    }
}