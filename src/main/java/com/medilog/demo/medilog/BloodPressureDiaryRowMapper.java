package com.medilog.demo.medilog;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class BloodPressureDiaryRowMapper implements RowMapper<BloodPressureDiary> {
    @Override
    public BloodPressureDiary mapRow(ResultSet resultSet, int i) throws SQLException {
        BloodPressureDiary bloodPressureDiary = new BloodPressureDiary();
        bloodPressureDiary.setUserId(resultSet.getInt("user_id"));
        bloodPressureDiary.setDate(resultSet.getObject("date", LocalDate.class));
        bloodPressureDiary.setTime(resultSet.getObject("time", LocalTime.class));
        bloodPressureDiary.setSystolic(resultSet.getInt("systolic"));
        bloodPressureDiary.setDiastolic(resultSet.getInt("diastolic"));
        bloodPressureDiary.setPulse(resultSet.getInt("pulse"));
        bloodPressureDiary.setAddInfo(resultSet.getString("add_info"));
        return bloodPressureDiary;
    }
}
