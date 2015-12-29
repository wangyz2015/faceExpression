package com.yazhou.faceExpression.model;

import java.util.Date;

/**
 * Created by root on 12/29/15.
 */
public class ImageEntity {
    //每个图片都有一个图片id
    private long id;

    //每个图片都有一个优先级
    private long priority;

    //每个图片都有一个所属修列
    private long serialId;

    //每个图片都有一个下载次数
    private long downloadCount;

    //每个图片都有创建时间
    private Date createDate;

    //每个图片都有最近更新时间
    private Date updateDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
    }

    public long getSerialId() {
        return serialId;
    }

    public void setSerialId(long serialId) {
        this.serialId = serialId;
    }

    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
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