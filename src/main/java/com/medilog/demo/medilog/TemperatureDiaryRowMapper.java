package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class TemperatureDiaryRowMapper implements RowMapper<TemperatureDiary> {
    @Override
    public TemperatureDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        TemperatureDiary temperatureDiary = new TemperatureDiary();
        temperatureDiary.setUserId(resultSet.getInt("user_id"));
        temperatureDiary.setDate(resultSet.getObject("date", LocalDate.class));
        temperatureDiary.setTime(resultSet.getObject("time", LocalTime.class));
        temperatureDiary.setTemp(resultSet.getBigDecimal("temp"));
        temperatureDiary.setAddInfo(resultSet.getString("add_info"));
        return temperatureDiary;
    }
}
