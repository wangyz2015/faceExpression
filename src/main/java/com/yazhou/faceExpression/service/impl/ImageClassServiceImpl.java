package com.yazhou.faceExpression.service.impl;

import com.yazhou.faceExpression.model.ImageClassEntity;
import com.yazhou.faceExpression.service.ImageClassService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangyazhou on 16/2/20.
 */
public class ImageClassServiceImpl implements ImageClassService {
    private static final String GET_ALL_IMAGE_CLASSED_SQL = "select * from image_class";
    private static final String ADD_IMAGE_CLASS_SQL = "insert into image_class_table(id, image_class_name, image_class_icon, update_date, create_date, priority) values(?,?,?,?,?,?)";
    private static final String DELETE_IMAGE_CLASS_SQL = "delete from image_class_table where id = ?";
    private static final String GET_IMAGE_CLASS_LIST_SQL = "select * from image_class where id = ?";
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void addImageClass(ImageClassEntity imageClassEntity) {
        jdbcTemplate.update(ADD_IMAGE_CLASS_SQL, generateAddImageClassParams(imageClassEntity));
    }

    private Object[] generateAddImageClassParams(ImageClassEntity imageClassEntity) {
        return new Object[]{imageClassEntity.getId(), imageClassEntity.getImageClassName(), imageClassEntity.getUpdateTime(), imageClassEntity.getCreateTime(), imageClassEntity.getPriority()};
    }

    public void deleteImageClass(long classImageId) {
        jdbcTemplate.update(DELETE_IMAGE_CLASS_SQL, new Object[]{classImageId});
    }

    public List<ImageClassEntity> getImageClassList(long imageClassId) {
        return jdbcTemplate.query(GET_IMAGE_CLASS_LIST_SQL, new Object[]{imageClassId}, new ImageClassRowMapper());
    }

    public List<ImageClassEntity> getAllImageClassList() {
        return jdbcTemplate.query(GET_ALL_IMAGE_CLASSED_SQL, new ImageClassRowMapper());
    }

    private class ImageClassRowMapper implements RowMapper<ImageClassEntity> {
        public ImageClassEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ImageClassEntity imageClassEntity = new ImageClassEntity();
            imageClassEntity.setId(rs.getLong("id"));
            imageClassEntity.setCreateTime(rs.getLong("create_time"));
            imageClassEntity.setImageClassIcon(rs.getString("image_class_icon"));
            imageClassEntity.setImageClassName(rs.getString("image_class_name"));
            imageClassEntity.setPriority(rs.getLong("priority"));
            imageClassEntity.setUpdateTime(rs.getLong("update_time"));
            return imageClassEntity;
        }
    }
}
