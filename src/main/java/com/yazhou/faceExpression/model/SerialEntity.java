package com.yazhou.faceExpression.model;

import java.util.Date;

/**
 * Created by root on 12/29/15.
 */
public class SerialEntity {
    //每个系列都有一个系列id
    private long id;

    //每个系列都有一个系列名字
    private String serialName;

    //每个系列都有一个优先级
    private String priority;

    //每个系列都有创建时间
    private Date createDate;

    //每个系列都有最近被更新的实际
    private Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialName() {
        return serialName;
    }

    public void setSerialName(String serialName) {
        this.serialName = serialName;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
