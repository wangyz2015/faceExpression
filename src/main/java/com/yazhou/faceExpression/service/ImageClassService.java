package com.yazhou.faceExpression.service;

import com.yazhou.faceExpression.model.ImageClassEntity;

import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public interface ImageClassService {
    public void addImageClass(ImageClassEntity imageClassEntity);

    public void deleteImageClass(long classImageId);

    public List<ImageClassEntity> getImageClassList(long imageClassId);

    public List<ImageClassEntity> getAllImageClassList();
}
