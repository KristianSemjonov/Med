package com.medilog.demo.medilog;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class MedilogService {

    @Autowired
    private MedilogRepository medilogRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String firstName, String lastName, long idCode, String username, String password) {
        if (medilogRepository.checkForUser(idCode)) {
            throw new MedException("Kasutaja on juba olemas");
        } else {
            medilogRepository.createUser(firstName, lastName, idCode, username, passwordEncoder.encode(password))   ;
        }
    }

    public String login(String username, String rawPassword) {
        // TODO 1 encodedPassword = repository.getPassword()
        // TODO 2 hasLoggedIn = passwordEncoder.matches(.....
        // TODO 3 if(hasLoggedIn) return token
        // TODO 4 else throw new SomeException("you forgot your password")
        String encodedPassword = medilogRepository.getPassword(username);
        boolean hasLoggedIn = passwordEncoder.matches(rawPassword, encodedPassword);
        if (!hasLoggedIn) {
            throw new MedException("Kontrollige salasõna õigsust");
        } else {
            Date now = new Date();
            Date tokenExpiryDate = new Date(now.getTime() + 1000 * 60 * 60);
            JwtBuilder builder = Jwts.builder()
                    .setExpiration(tokenExpiryDate)
                    .setIssuedAt(new Date())
                    .setIssuer("medilog")
                    .signWith(SignatureAlgorithm.HS256, "secret")
                    .claim("username", username);
            return builder.compact();
        }
    }

    public void bloodPressure(String username, LocalDate date, LocalTime time, int systolic, int diastolic, int pulse, String addInfo) {
        Integer userId = medilogRepository.getUserId(username);
        medilogRepository.bloodPressure(userId, date, time, systolic, diastolic, pulse, addInfo);
    }

    public void bloodSugar(String username, LocalDate date, LocalTime time, BigDecimal bloodSugar, String addInfo) {
        Integer userId = medilogRepository.getUserId(username);
        medilogRepository.bloodSugar(userId, date, time, bloodSugar, addInfo);
    }

    public void weight(String username, LocalDate date, LocalTime time, BigDecimal weight, BigDecimal height, BigDecimal bmi, String addInfo) {
        bmi = (weight.divide(height.multiply(height), RoundingMode.HALF_UP));
        Integer userId = medilogRepository.getUserId(username);
        medilogRepository.weight(userId, date, time, weight, height, bmi, addInfo);
    }

    public void bodyTemp(String username, LocalDate date, LocalTime time, BigDecimal temp, String addInfo) {
        Integer userId = medilogRepository.getUserId(username);
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
