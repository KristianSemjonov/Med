package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BloodSugarDiaryRowMapper implements RowMapper<BloodSugarDiary> {
    @Override
    public BloodSugarDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
