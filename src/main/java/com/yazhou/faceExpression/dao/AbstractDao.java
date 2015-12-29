package com.yazhou.faceExpression.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;

/**
 * Created by root on 12/29/15.
 */
public class AbstractDao {
    @Resource
    protected JdbcTemplate jdbcTemplate;

}
