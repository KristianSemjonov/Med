package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BloodPressureDiaryRowMapper implements RowMapper<BloodPressureDiary> {
    @Override
    public BloodPressureDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
