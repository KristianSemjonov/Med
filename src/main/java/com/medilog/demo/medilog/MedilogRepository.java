package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
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

    public String getPassword(String username) {
        String sql = "SELECT password FROM users WHERE username = :username";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, String.class);
    }
    
    public void bloodPressure(int userId, LocalDate date, LocalTime time, int systolic, int diastolic, int pulse, String addInfo) {
        String sql = "INSERT INTO blood_pressure (user_id, date, time, systolic, diastolic, pulse, add_info) " +
                "VALUES (:userId, :date, :time, :systolic, :diastolic, :pulse, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("date", date);
        paramMap.put("time", time);
        paramMap.put("systolic", systolic);
        paramMap.put("diastolic", diastolic);
        paramMap.put("pulse", pulse);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bloodSugar(int userId, LocalDate date, LocalTime time, BigDecimal bloodSugar, String addInfo) {
        String sql = "INSERT INTO blood_sugar (user_id, date, time, blood_sugar, add_info) " +
                "VALUES (:userId, :date, :time, :bloodSugar, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("date", date);
        paramMap.put("time", time);
        paramMap.put("bloodSugar", bloodSugar);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void weight(int userId, LocalDate date, LocalTime time, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        String sql = "INSERT INTO weight_bmi (user_id, date, time, weight, height, bmi, add_info) VALUES (:userId, :date, :time, :weight, :height, :bmi, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("date", date);
        paramMap.put("time", time);
        paramMap.put("weight", weight);
        paramMap.put("height", height);
        paramMap.put("bmi", bmi);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public void bodyTemp(int userId, LocalDate date, LocalTime time, BigDecimal temp, String addInfo) {
        String sql = "INSERT INTO body_temp (user_id, date, time, temp, add_info) VALUES (:userId, :date, :time, :temp, :addInfo)";
        Map<String, Object> paramMap = new HashMap();
        paramMap.put("userId", userId);
        paramMap.put("date", date);
        paramMap.put("time", time);
        paramMap.put("temp", temp);
        paramMap.put("addInfo", addInfo);
        jdbcTemplate.update(sql, paramMap);
    }

    public List diaryBloodPressure(int userId) {
        String sql = "SELECT * FROM blood_pressure WHERE user_id = :userId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        return jdbcTemplate.query(sql,paramMap, new BloodPressureDiaryRowMapper());
    }

    public List diaryBloodSugar(int userId) {
        String sql = "SELECT * FROM blood_sugar WHERE user_id = :userId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        return jdbcTemplate.query(sql,paramMap, new BloodSugarDiaryRowMapper());
    }

    public List diaryWeight(int userId) {
        String sql = "SELECT * FROM weight_bmi WHERE user_id = :userId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        return jdbcTemplate.query(sql,paramMap, new WeightDiaryRowMapper());
    }

    public List diaryTemperature(int userId) {
        String sql = "SELECT * FROM body_temp WHERE user_id = :userId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        return jdbcTemplate.query(sql,paramMap, new TemperatureDiaryRowMapper());
    }

    public boolean checkForUser(long idCode) {
        String sql = "SELECT count(*) FROM users WHERE id_code = :idCode";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idCode", idCode);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class) > 0;
    }

    public Integer getUserId(String username) {
        String sql = "SELECT user_id FROM users WHERE username = :username";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }
}
