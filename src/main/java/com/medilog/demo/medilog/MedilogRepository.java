package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MedilogRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(String firstName, String lastName, long idCode, String username, String password) {
        String sql = "INSERT INTO users (first_name, last_name, id_code, username, password) " +
                "VALUES (:firstName, :lastName, :idCode, :username, :password)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstName", firstName);
        paramMap.put("lastName", lastName);
        paramMap.put("idCode", idCode);
        paramMap.put("username", username);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bloodPressure(int userId, LocalDateTime dateTime, int systolic, int diastolic, int pulse, String addInfo) {
        String sql = "INSERT INTO blood_pressure (user_id, date_time, systolic, diastolic, pulse, add_info) " +
                "VALUES (:userId, :dateTime, : systolic, :diastolic, :pulse, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("dateTime", dateTime);
        paramMap.put("systolic", systolic);
        paramMap.put("diastolic", diastolic);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bloodSugar(int userId, LocalDateTime dateTime, BigDecimal bloodSugar, String addInfo) {
        String sql = "INSERT INTO blood_sugar (user_id, date_time, blood_sugar, add_info) " +
                "VALUES (:userId, :dateTime, :bloodSugar, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("dateTime", dateTime);
        paramMap.put("bloodSugar", bloodSugar);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void weight(int userId, LocalDateTime dateTime, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        String sql = "INSERT INTO weight_bmi (user_id, date_time, weight, height, bmi, add_info) VALUES (:userId, :dateTime, :weight, :height, :bmi, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("dateTime", dateTime);
        paramMap.put("weight", weight);
        paramMap.put("height", height);
        paramMap.put("bmi", bmi);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bodyTemp(int userId, LocalDateTime dateTime, BigDecimal temp, String addInfo) {
        String sql = "INSERT INTO body_temp (user_id, date_time, temp, add_info) VALUES (:userId, :dateTime, :temp, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("dateTime", dateTime);
        paramMap.put("temp", temp);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

}
