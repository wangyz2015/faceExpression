package com.yazhou.faceExpression.service;

import com.yazhou.faceExpression.model.ImageSerialEntity;

import java.util.List;

/**
 * 这个接口提供serial的增 删 查
 * Created by wangyazhou on 16/1/10.
 */
public interface ImageSerialService {

    void addImageSerial(ImageSerialEntity serial);

    void deleteImageSerial(long serialId);

    List<ImageSerialEntity> getSerialList(long serialId);

    /**
     * 获取第dayOff天更新的系列图片
     * @param dayOff
     * @return
     */
    List<ImageSerialEntity> getUpdatedSerials(long dayOff);
}
