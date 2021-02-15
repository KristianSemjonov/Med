package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MedilogService {

    @Autowired
    private MedilogRepository medilogRepository;

    @Transactional
    public void createUser(String firstName, String lastName, long idCode, String username, String password) {

        if (medilogRepository.checkForUser(idCode)) {
            throw new MedException("Kasutaja on juba olemas");
        } else {
            medilogRepository.createUser(firstName, lastName, idCode, username, password);
        }
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

    public List diaryBloodPressure(int userId) {
        return medilogRepository.diaryBloodPressure(userId);
    }

    public List diaryBloodSugar(int userId) {
        return medilogRepository.diaryBloodSugar(userId);
    }

    public List diaryWeight(int userId) {
        return medilogRepository.diaryWeight(userId);
    }

    public List diaryTemperature(int userId) {
        return medilogRepository.diaryTemperature(userId);
    }
}
