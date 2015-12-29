package com.yazhou.faceExpression.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by root on 12/29/15.
 */
public class ImageUtil {
    private static final String IMAGE_PATH = "/home/wangyazhou/tmp/faceExpression/data/images/";

    //流试存储
    public static void uploadImage(byte[] imageData, long imageId) {
        OutputStream os = new FileOutputStream(Files.createFile(IMAGE_PATH + String.valueOf(imageId), null));
    }

    public static byte[] downloadImage(long id) {
    }
}

