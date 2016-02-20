package com.yazhou.faceExpression.service.impl;

import com.yazhou.faceExpression.model.ImageEntity;
import com.yazhou.faceExpression.model.ImageTag;
import com.yazhou.faceExpression.service.ImageService;
import com.yazhou.faceExpression.utils.DateUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public class ImageServiceImpl implements ImageService {
    private static final String ADD_IMAGE_SQL = "insert into image_table(id, priority, serial_id, download_count, create_date, update_date. image_tag) values(?,?,?,?,?,?,?)";
    private static final String DELETE_IMAGE_SQL = "delete from image_table where id = ?";
    private static final String GET_IMAGE_LIST_SQL = "select * from image_table where id = ?";
    private static final String GET_HOT_IMAGE_LIST_SQL = "select * from image_table where image_tag = ?";
    private static final String GET_UPDATED_IMAGE_SQL = "select * from image_table where update_date > ? and update_date <= ?";

    @Resource
    private JdbcTemplate jdbcTemplate;


    public void addImage(ImageEntity imageEntity) {
        jdbcTemplate.update( ADD_IMAGE_SQL, generateAddImageParams(imageEntity));
    }

    private Object[] generateAddImageParams(ImageEntity imageEntity) {
        return new Object[]{imageEntity.getId(), imageEntity.getPriority(), imageEntity.getSerialId(), imageEntity.getDownloadCount(), imageEntity.getCreateTime(), imageEntity.getUpdateTime(), imageEntity.getImageTag().code};
    }

    public void deleteImage(long imageId) {
        jdbcTemplate.update(DELETE_IMAGE_SQL, new Object[]{imageId});
    }

    public List<ImageEntity> getImageList(long imageId) {
        return jdbcTemplate.query(GET_IMAGE_LIST_SQL, new Object[]{imageId}, new ImageRowMapper());
    }

    public List<ImageEntity> getHotImageList(ImageTag imageTag) {
        return jdbcTemplate.query(GET_HOT_IMAGE_LIST_SQL, new Object[]{imageTag.code}, new ImageRowMapper());
    }

    public List<ImageEntity> getUpdatedImages(long dayOff) {
        return jdbcTemplate.query(GET_UPDATED_IMAGE_SQL, generateGetUpdatedImagesParams(dayOff), new ImageRowMapper());
    }

    private Object[] generateGetUpdatedImagesParams(long dayOff) {
        long from = DateUtil.getNextNDay(dayOff);
        long to = DateUtil.getNextNDay(dayOff + 1);
        return new Object[]{from, to};
    }

    private class ImageRowMapper implements RowMapper<ImageEntity> {
        public ImageEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ImageEntity imageEntity = new ImageEntity();
            imageEntity.setId(rs.getLong("id"));
            imageEntity.setCreateTime(rs.getLong("create_time"));
            imageEntity.setDownloadCount(rs.getLong("download_count"));
            imageEntity.setImageTag(ImageTag.codeOf(rs.getInt("image_tag")));
            imageEntity.setPriority(rs.getLong("priority"));
            imageEntity.setSerialId(rs.getLong("serialId"));
            imageEntity.setUpdateTime(rs.getLong("update_time"));
            return imageEntity;
        }
    }



}
