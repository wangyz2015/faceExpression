package com.yazhou.faceExpression.service.impl;

import com.yazhou.faceExpression.model.BannerEntity;
import com.yazhou.faceExpression.model.ImageSerialEntity;
import com.yazhou.faceExpression.service.BannerService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public class BannerServiceImpl implements BannerService {
    private static final String ADD_BANNER_SQL = "insert into banner_table(id, banner_url) values(?,?)";
    private static final String DELETE_BANNER_SQL = "delete from banner_table where id = ?";
    private static final String GET_BANNER_LIST_SQL = "select * from banner_table where id = ?";
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addBanner(BannerEntity bannerEntity) {
        jdbcTemplate.update(ADD_BANNER_SQL, generateAddBannerParams(bannerEntity));
    }

    private Object[] generateAddBannerParams(BannerEntity bannerEntity) {
        return new Object[]{bannerEntity.getId(), bannerEntity.getBannerUrl()};
    }

    public void deleteBanner(long bannerId) {
        jdbcTemplate.update(DELETE_BANNER_SQL, new Object[]{bannerId});
    }

    public List<BannerEntity> getBannerList(long bannerId) {
        return jdbcTemplate.query(GET_BANNER_LIST_SQL, new Object[]{bannerId}, new BannerRowMapper());
    }

    public List<BannerEntity> getAllBannerList() {
        return jdbcTemplate.query(GET_BANNER_LIST_SQL, new BannerRowMapper());
    }

    private class BannerRowMapper implements RowMapper<BannerEntity> {
        public BannerEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            BannerEntity bannerEntity = new BannerEntity();
            bannerEntity.setId(rs.getLong("id"));
            bannerEntity.setBannerUrl(rs.getString("banner_url"));
            return bannerEntity;
        }
    }
}
