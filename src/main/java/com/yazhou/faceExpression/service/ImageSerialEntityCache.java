package com.yazhou.faceExpression.service;

import com.google.common.collect.Lists;
import com.yazhou.faceExpression.model.ImageSerialEntity;
import com.yazhou.faceExpression.utils.ThreadPoolUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 这个类用于系列信息缓存
 * Created by wangyazhou on 16/1/10.
 */
public class ImageSerialEntityCache implements Runnable{

    public static final String SELECT_UPDATE_SERIAL_SQL = "select id, serial_name, priority, create_time, update_time from XXXXtable where update_time > ?";

    @Resource
    private JdbcTemplate jdbcTemplate;

    private long timestamp;//更新时间戳

    private Map<Long, ImageSerialEntity> serialImageEntityMap;
    private static volatile ImageSerialEntityCache imageSerialEntityCache;

    //私有构造
    private ImageSerialEntityCache() {
         ThreadPoolUtils.scheduleAtFix(this, 60, 60);
    }

    //单例模式
    public static ImageSerialEntityCache getInstance() {
        if (imageSerialEntityCache == null) {
            synchronized (ImageSerialEntityCache.class){
                if (imageSerialEntityCache == null) {
                    imageSerialEntityCache = new ImageSerialEntityCache();
                }
            }

        }
        return imageSerialEntityCache;
    }


    public void run() {
        List<ImageSerialEntity> imageSerialEntityList = jdbcTemplate.query(SELECT_UPDATE_SERIAL_SQL, new Object[]{timestamp}, new RowMapper<ImageSerialEntity>() {
            public ImageSerialEntity mapRow(ResultSet resultSet, int i) throws SQLException {
                return new ImageSerialEntity(resultSet.getLong(0), resultSet.getString(1), resultSet.getLong(2), resultSet.getLong(3), resultSet.getLong(4));
            }
        });

        for (ImageSerialEntity imageSerialEntity : imageSerialEntityList) {
            if (imageSerialEntity.getUpdateTime() > timestamp) {
                timestamp = imageSerialEntity.getUpdateTime();
            }
            serialImageEntityMap.put(imageSerialEntity.getId(), imageSerialEntity);
        }
    }

    public boolean contain(long serialId) {
        return serialImageEntityMap.containsKey(serialId);
    }

    public List<ImageSerialEntity> getSerialImageEntity(long serialId) {
        return Lists.newArrayList(serialImageEntityMap.get(serialId));
    }
}
