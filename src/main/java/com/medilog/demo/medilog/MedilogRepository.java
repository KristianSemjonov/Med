package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Repository
public class MedilogRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createUser(String firstName, String lastName, long idCode, String username, String password) {
        String sql = "INSERT INTO users (first_name, last_name, id_code, username, password) " +
                "VALUES (:firstName, :lastName, :idCode, :username, :password)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("firstname", firstName);
        paramMap.put("lastname", lastName);
        paramMap.put("idcode", idCode);
        paramMap.put("username", username);
        paramMap.put("password", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bloodPressure(String userId, LocalDateTime dateTime, int systolic, int diastolic, int pulse, String addInfo) {
        String sql = "INSERT INTO blood_pressure (user_id, date_time, systolic, diastolic, pulse, add_info) " +
                "VALUES (:userId, :dateTime, : systolic, :diastolic, :pulse, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userid", userId);
        paramMap.put("datetime", dateTime);
        paramMap.put("systolic", systolic);
        paramMap.put("diastolic", diastolic);
        paramMap.put("add_info", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bloodSugar(String userId, LocalDateTime dateTime, BigDecimal bloodSugar, String addInfo) {
        String sql = "INSERT INTO blood_sugar (user_id, date_time, blood_sugar, add_info) " +
                "VALUES (:userId, :dateTime, : systolic, :diastolic, :pulse, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userid", userId);
        paramMap.put("datetime", dateTime);
        paramMap.put("blood_sugar", bloodSugar);
        paramMap.put("add_info", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void weight(String userId, LocalDateTime dateTime, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        String sql = "INSERT INTO weight_bmi (user_id, date_time, weight, height, bmi, add_info) VALUES (:userId, :dateTime, :weight, :height, :bmi, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userid", userId);
        paramMap.put("datetime", dateTime);
        paramMap.put("weight", weight);
        paramMap.put("height", height);
        paramMap.put("bmi", bmi);
        paramMap.put("add_info", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

}
