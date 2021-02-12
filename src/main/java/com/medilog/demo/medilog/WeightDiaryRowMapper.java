package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class WeightDiaryRowMapper implements RowMapper<WeightDiary> {
    @Override
    public WeightDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        WeightDiary weightDiary = new WeightDiary();
        weightDiary.setUserId(resultSet.getInt("user_id"));
        weightDiary.setDate(resultSet.getObject("date", LocalDate.class));
        weightDiary.setTime(resultSet.getObject("time", LocalTime.class));
        weightDiary.setWeight(resultSet.getBigDecimal("weight"));
        weightDiary.setHeight(resultSet.getBigDecimal("height"));
        weightDiary.setBmi(resultSet.getBigDecimal("bmi"));
        weightDiary.setAddInfo(resultSet.getString("add_info"));
        return weightDiary;
    }
}
