package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MedilogService {

    @Autowired
    private MedilogRepository medilogRepository;

    @Transactional
    public void createUser(String firstName, String lastName, long idCode, String username, String password) {
        medilogRepository.createUser(firstName, lastName, idCode, username, password);
    }
    public void bloodPressure(int userId, LocalDate date, LocalTime time, int systolic, int diastolic, int pulse, String addInfo) {
        medilogRepository.bloodPressure(userId, date, time, systolic, diastolic, pulse, addInfo);
    }

    public void bloodSugar(int userId, LocalDate date, LocalTime time, BigDecimal bloodSugar, String addInfo) {
        medilogRepository.bloodSugar(userId, date, time, bloodSugar, addInfo);
    }

    public void weight(int userId, LocalDate date, LocalTime time, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        bmi = (weight.divide(height.multiply(height), RoundingMode.HALF_UP));
        medilogRepository.weight(userId, date, time, weight, height, bmi, addInfo);
    }

    public void bodyTemp(int userId, LocalDate date, LocalTime time, BigDecimal temp, String addInfo) {
        medilogRepository.bodyTemp(userId, date, time, temp, addInfo);
    }

}
