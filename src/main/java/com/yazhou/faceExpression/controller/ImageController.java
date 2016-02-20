package com.yazhou.faceExpression.controller;

import com.yazhou.faceExpression.model.*;
import com.yazhou.faceExpression.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 这个类提供系列的增删改接口
 * Created by wangyazhou on 16/1/10.
 */
@Controller
@RequestMapping(value = "image/", method = RequestMethod.GET)
public class ImageController {

    @Resource
    private ImageSerialService imageSerialService;

    @Resource
    private BannerService bannerService;

    @Resource
    private ImageService imageService;

    @Resource
    private ImageClassService imageClassService;

    private ImageSerialEntityCache imageSerialEntityCache;

    @RequestMapping(value = "addImage", method = RequestMethod.POST)
    public void addImage(@RequestParam(value = "image", required = true) ImageEntity image) {
        imageService.addImage(image);
    }

    @RequestMapping(value = "deleteImage", method = RequestMethod.GET)
    public void deleteImage(@RequestParam(value = "imageId", required = true) long imageId) {
        imageService.deleteImage(imageId);
    }


    @RequestMapping(value = "getImageList", method = RequestMethod.GET)
    public List<ImageEntity> getImageList(@RequestParam(value = "imageId", required = true) long imageId) {
        return imageService.getImageList(imageId);
    }

    @RequestMapping(value = "getUpdatedImages", method = RequestMethod.GET)
    public List<ImageEntity> getUpdatedImages(long dayOff) {
        return imageService.getUpdatedImages(dayOff);
    }

    @RequestMapping(value = "serial/addSerial", method = RequestMethod.GET)
    public void addSerial(@RequestParam(value = "serial", required = true) ImageSerialEntity serial) {
        imageSerialService.addImageSerial(serial);
    }

    @RequestMapping(value = "serial/deleteSerial", method = RequestMethod.GET)
    public void deleteSerial(@RequestParam(value = "serialId", required = true) long serialId) {
        imageSerialService.deleteImageSerial(serialId);
    }

    @RequestMapping(value = "serial/getSerialList", method = RequestMethod.GET)
    public List<ImageSerialEntity> getSerialList(@RequestParam(value = "serialId", required = true) long serialId) {
        //双取
        if (imageSerialEntityCache.contain(serialId)) {
            return imageSerialEntityCache.getSerialImageEntity(serialId);
        }
        return imageSerialService.getSerialList(serialId);
    }

    @RequestMapping(value = "serial/getUpdatedSerials", method = RequestMethod.GET)
    public List<ImageSerialEntity> getUpdatedSerials(long dayOff) {
        return imageSerialService.getUpdatedSerials(dayOff);
    }

    @RequestMapping(value = "class/addImageClass", method = RequestMethod.POST)
    public void addCImageClass(@RequestParam(value = "imageClass", required = true) ImageClassEntity imageClassEntity) {
        imageClassService.addImageClass(imageClassEntity);
    }

    @RequestMapping(value = "class/deleteImageClass", method = RequestMethod.GET)
    public void addCImageClass(@RequestParam(value = "imageClassId", required = true) long imageClassId) {
        imageClassService.deleteImageClass(imageClassId);
    }

    @RequestMapping(value = "class/getImageClassList", method = RequestMethod.GET)
    public List<ImageClassEntity> getImageClassList(@RequestParam(value = "imageClassId", required = true) long imageClassId) {
        return imageClassService.getImageClassList(imageClassId);
    }

    @RequestMapping(value = "class/getAllImageClasses", method = RequestMethod.GET)
    public List<ImageClassEntity> getAllImageClasses() {
        return imageClassService.getAllImageClassList();
    }

    @RequestMapping(value = "banner/getAllBannerList", method = RequestMethod.GET)
    public List<BannerEntity> getBannerList() {
        return bannerService.getAllBannerList();
    }

    @RequestMapping(value = "hot/getHotImage", method = RequestMethod.GET)
    public List<ImageEntity> getHotImageList() {
        return imageService.getHotImageList(ImageTag.HOT);
    }

}
