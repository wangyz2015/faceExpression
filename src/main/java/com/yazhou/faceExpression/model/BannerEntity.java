package com.yazhou.faceExpression.model;

/**
 * 轮播图片
 * Created by wangyazhou on 16/2/20.
 */
public class BannerEntity {
    private String bannerUrl;

    private long id;

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long bannerId) {
        this.id = bannerId;
    }
}
