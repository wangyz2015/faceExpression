package com.yazhou.faceExpression.service;

import com.yazhou.faceExpression.model.BannerEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public interface BannerService {

    public void addBanner(BannerEntity bannerEntity);

    public void deleteBanner(long bannerId);

    public List<BannerEntity> getBannerList(long bannerId);

    public List<BannerEntity> getAllBannerList();
}
