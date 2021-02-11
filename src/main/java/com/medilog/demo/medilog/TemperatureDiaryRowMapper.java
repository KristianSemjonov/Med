package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TemperatureDiaryRowMapper implements RowMapper<TemperatureDiary> {
    @Override
    public TemperatureDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
