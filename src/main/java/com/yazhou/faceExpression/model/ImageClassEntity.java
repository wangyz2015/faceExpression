package com.yazhou.faceExpression.model;

/**
 * 这个实体与系列实体关联
 * Created by wangyazhou on 16/1/10.
 */
public class ImageClassEntity {
    private long id;
    private String imageClassName;//系列名
    private long priority;//优先级
    private long createTime;//创建时间
    private long updateTime;//更新时间
    private String imageClassIcon;//分类logo

    public long getId() {
        return id;
    }

    public String getImageClassIcon() {
        return imageClassIcon;
    }

    public void setImageClassIcon(String classIcon) {
        this.imageClassIcon = classIcon;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageClassName() {
        return imageClassName;
    }

    public void setImageClassName(String className) {
        this.imageClassName = className;
    }

    public long getPriority() {
        return priority;
    }

    public void setPriority(long priority) {
        this.priority = priority;
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
}
