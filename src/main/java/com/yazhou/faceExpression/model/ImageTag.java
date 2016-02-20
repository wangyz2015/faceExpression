package com.yazhou.faceExpression.model;

/**
 * Created by wangyazhou on 16/2/20.
 */
public enum  ImageTag {
    HOT(0, "热门");
    private static ImageTag[] imageTags = values();
    public int code;
    public String name;

    ImageTag(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ImageTag codeOf(int code) {
        for (ImageTag imageTag:imageTags) {
            if (imageTag.code == code) {
                return imageTag;
            }
        }
        return null;
    }
}
