package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RequestMapping("medilog")
@RestController
public class MedilogController {

    @Autowired
    private MedilogService medilogService;

    // http://localhost:8081/medilog/createuser?firstName=Mari&lastName=Maasikas&idCode=11111111111&username=mammu&password=Mammu555
    @PostMapping("createuser")
    public void createUser(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("idCode") long idCode,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password) {
        medilogService.createUser(firstName, lastName, idCode, username, password);
    }

    // http://localhost:8081/medilog/login?username=mammu&password=Mammu555
    @GetMapping("login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String rawPassword) {
        return medilogService.login(username, rawPassword);
    }

    // http://localhost:8081/medilog/bloodpressure?userId=1&date=2021-02-04&time=16:20&systolic=141&diastolic=80&pulse=72&addInfo=test
    @PostMapping("bloodpressure")
    public void bloodPressure(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                              @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,
                              @RequestParam("systolic") int systolic,
                              @RequestParam("diastolic") int diastolic,
                              @RequestParam(value = "pulse", required = false) int pulse,
                              @RequestParam(value = "addInfo", required = false) String addInfo,
                              Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        medilogService.bloodPressure(userDetails.getUsername(), date, time, systolic, diastolic, pulse, addInfo);
    }

    // http://localhost:8081/medilog/bloodsugar?userId=1&date=2021-02-04&time=16:20&bloodSugar=5.6&addInfo=test
    @PostMapping("bloodsugar")
    public void bloodSugar(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                           @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,
                           @RequestParam("bloodSugar") BigDecimal bloodSugar,
                           @RequestParam(value = "addInfo", required = false) String addInfo,
                           Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        medilogService.bloodSugar(userDetails.getUsername(), date, time, bloodSugar, addInfo);
    }

    // http://localhost:8081/medilog/weight?userId=1&date=2021-02-04&time=16:20&weight=76&height=180&bmi=23.5&addInfo=test
    @PostMapping("weight")
    public void weight(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                       @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,
                       @RequestParam("weight") BigDecimal weight,
                       @RequestParam("height") BigDecimal height,
                       @RequestParam("bmi") BigDecimal bmi,
                       @RequestParam(value = "addInfo", required = false) String addInfo,
                       Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        medilogService.weight(userDetails.getUsername(), date, time, weight, height, bmi, addInfo);
    }

    // http://localhost:8081/medilog/temperature?userId=1&date=2021-02-04&time=16:20&temp=37.6&addInfo=test
    @PostMapping("temperature")
    public void bodyTemp(@RequestParam("date") @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                         @RequestParam("time") @DateTimeFormat(iso=DateTimeFormat.ISO.TIME) LocalTime time,
                         @RequestParam("temp") BigDecimal temp,
                         @RequestParam(value = "addInfo", required = false) String addInfo,
                         Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        medilogService.bodyTemp(userDetails.getUsername(), date, time, temp, addInfo);
    }

    // http://localhost:8081/medilog/diarybloodpressure?userId=1
    @GetMapping("diarybloodpressure")
    public List<BloodPressureDiary> diaryBloodPressure(@RequestParam ("userid") int userId) {
        return medilogService.diaryBloodPressure(userId);
    }

    // http://localhost:8081/medilog/diarybloodsugar?userId=1
    @GetMapping("diarybloodsugar")
    public List<BloodSugarDiary> diaryBloodSugar(@RequestParam ("userid") int userId) {
        return medilogService.diaryBloodSugar(userId);
    }

    // http://localhost:8081/medilog/diaryweight?userId=1
    @GetMapping("diaryweight")
    public List<WeightDiary> diaryWeight(@RequestParam ("userid") int userId) {
        return medilogService.diaryWeight(userId);
    }

    // http://localhost:8081/medilog/diarytemperature?userId=1
    @GetMapping("diarytemperature")
    public List<TemperatureDiary> diaryTemperature(@RequestParam ("userid") int userId) {
        return medilogService.diaryTemperature(userId);
    }

}
