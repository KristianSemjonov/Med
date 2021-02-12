package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class BloodSugarDiaryRowMapper implements RowMapper<BloodSugarDiary> {
    @Override
    public BloodSugarDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        BloodSugarDiary bloodSugarDiary = new BloodSugarDiary();
        bloodSugarDiary.setUserId(resultSet.getInt("user_id"));
        bloodSugarDiary.setDate(resultSet.getObject("date", LocalDate.class));
        bloodSugarDiary.setTime(resultSet.getObject("time", LocalTime.class));
        bloodSugarDiary.setBloodSugar(resultSet.getBigDecimal("blood_sugar"));
        bloodSugarDiary.setAddInfo(resultSet.getString("add_info"));

        return bloodSugarDiary;
    }
}