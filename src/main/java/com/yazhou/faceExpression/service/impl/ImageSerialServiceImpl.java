package com.yazhou.faceExpression.service.impl;

import com.yazhou.faceExpression.model.ImageEntity;
import com.yazhou.faceExpression.model.ImageSerialEntity;
import com.yazhou.faceExpression.model.ImageTag;
import com.yazhou.faceExpression.service.ImageSerialService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by wangyazhou on 16/1/10.
 */
@Service
public class ImageSerialServiceImpl implements ImageSerialService {
    private static final String ADD_IMAGE_SERIAL_SQL = "insert into image_serial_table(id, create_time, update_time, serial_image, serial_name, priority, image_class_id ) values(?,?,?,?,?,?)";
    private static final String DELETE_IMAGE_SERIAL_SQL = "delete form image_serial_table where id = ?";
    private static final String GET_IMAGE_SERIAL_LIST_SQL = "select * from image_serial_table where id = ?";
    @Resource
    private JdbcTemplate jdbcTemplate;


    public void addImageSerial(ImageSerialEntity serial) {
        jdbcTemplate.update(ADD_IMAGE_SERIAL_SQL, generateAddImageSerialParams(serial));
    }

    private Object[] generateAddImageSerialParams(ImageSerialEntity serial) {
        return new Object[]{serial.getId(), serial.getCreateTime(), serial.getUpdateTime(), serial.getSerialImage(), serial.getSerialName(), serial.getPriority(), serial.getImageClassId()};
    }

    public void deleteImageSerial(long serialId) {
        jdbcTemplate.update(DELETE_IMAGE_SERIAL_SQL, new Object[]{serialId});
    }

    public List<ImageSerialEntity> getSerialList(long serialId) {
        return jdbcTemplate.query(GET_IMAGE_SERIAL_LIST_SQL, new Object[]{serialId}, new ImageSerialRowMapper());
    }

    public List<ImageSerialEntity> getUpdatedSerials(long dayOff) {
        return null;
    }

    private class ImageSerialRowMapper implements RowMapper<ImageSerialEntity> {
        public ImageSerialEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ImageSerialEntity imageSerialEntity = new ImageSerialEntity();
            imageSerialEntity.setId(rs.getLong("id"));
            imageSerialEntity.setCreateTime(rs.getLong("create_time"));
            imageSerialEntity.setSerialImage(rs.getString("serial_image"));
            imageSerialEntity.setSerialName(rs.getString("serial_name"));
            imageSerialEntity.setPriority(rs.getLong("priority"));
            imageSerialEntity.setUpdateTime(rs.getLong("update_time"));
            imageSerialEntity.setImageClassId(rs.getLong("image_class_id"));
            return imageSerialEntity;
        }
    }
}
