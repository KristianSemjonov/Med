package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class MedilogService {

    @Autowired
    private MedilogRepository medilogRepository;

    @Transactional
    public void createUser(String firstName, String lastName, long idCode, String username, String password) {
        medilogRepository.createUser(firstName, lastName, idCode, username, password);
    }
    public void bloodPressure(String userId, LocalDateTime dateTime, int systolic, int diastolic, int pulse, String addInfo) {
        medilogRepository.bloodPressure(userId, dateTime, systolic, diastolic, pulse, addInfo);
    }

    public void bloodSugar(String userId, LocalDateTime dateTime, BigDecimal bloodSugar, String addInfo) {
        medilogRepository.bloodSugar(userId, dateTime, bloodSugar, addInfo);
    }

    public void weight(String userId, LocalDateTime dateTime, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        bmi = (weight.divide(height.multiply(height)));
        medilogRepository.weight(userId, dateTime, weight, height, bmi, addInfo);
    }

    public void bodyTemp(String userId, LocalDateTime dateTime, BigDecimal temp, String addInfo) {
        medilogRepository.bodyTemp(userId, dateTime, temp, addInfo);
    }

}
