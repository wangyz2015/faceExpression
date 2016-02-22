package com.yazhou.faceExpression.model;

import java.util.Date;

/**
 * Created by root on 12/29/15.
 */
public class ImageSerialEntity {
    //每个系列都有一个系列id
    private long id;

    //每个系列都有一个系列名字
    private String serialName;

    //每个系列都有一个优先级
    private long priority;

    //每个系列都有创建时间
    private long createTime;

    //每个系列都有最近被更新的实际
    private long updateTime;

    //每个系列都有一个招牌图片
    private String serialImage;

    //所属分类id
    private long imageClassId;

    public ImageSerialEntity() {}

    public ImageSerialEntity(long id, String serialName, long priority, long createTime, long updateTime) {
        this.id = id;
        this.serialName = serialName;
        this.priority =  priority;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

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

    public String getSerialImage() {
        return serialImage;
    }

    public void setSerialImage(String serialImage) {
        this.serialImage = serialImage;
    }

    public long getImageClassId() {
        return imageClassId;
    }

    public void setImageClassId(long imageClassId) {
        this.imageClassId = imageClassId;
    }
}
