package com.yazhou.faceExpression.service;

import com.yazhou.faceExpression.model.ImageClassEntity;
import com.yazhou.faceExpression.model.ImageEntity;
import com.yazhou.faceExpression.model.ImageTag;

import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public interface ImageService {
    public void addImage(ImageEntity imageEntity);

    public void deleteImage(long imageId);

    public List<ImageEntity> getImageList(long imageId);

    public List<ImageEntity> getHotImageList(ImageTag hotThreadhold);

    public List<ImageEntity> getUpdatedImages(long dayOff);

}
