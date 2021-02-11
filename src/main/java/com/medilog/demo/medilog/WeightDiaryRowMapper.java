package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeightDiaryRowMapper implements RowMapper<WeightDiary> {
    @Override
    public WeightDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        return null;
    }
}
