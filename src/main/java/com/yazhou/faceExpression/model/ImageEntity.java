package com.yazhou.faceExpression.model;

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
    private long createTime;

    //每个图片都有最近更新时间
    private long updateTime;

    private ImageTag imageTag;

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

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public ImageTag getImageTag() {
        return imageTag;
    }

    public void setImageTag(ImageTag imageTag) {
        this.imageTag = imageTag;
    }
}