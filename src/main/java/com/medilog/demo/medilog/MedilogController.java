package com.medilog.demo.medilog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("medilog")
@RestController
public class MedilogController {

    @Autowired
    private MedilogService medilogService;

    // http://localhost:8080/medilog/createuser?firstname=Mari&lastname=Maasikas&idcode=11111111111&username=mammu&password=Mammu555
    @PostMapping("createuser")
    public void createUser(@RequestParam("firstname") String firstName,
                           @RequestParam("lastname") String lastName,
                           @RequestParam("idcode") long idCode,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password) {
        medilogService.createUser(firstName, lastName, idCode, username, password);
    }

    // http://localhost:8080/medilog/bloodpressure?userId=1&datetime=2021-02-04T16:20:40&systolic=141&diastolic=80&pulse=72&addInfo=test
    @PostMapping("bloodpressure")
    public void bloodPressure(@RequestParam("userid") String userId,
                              @RequestParam("datetime") LocalDateTime dateTime,
                              @RequestParam("systolic") int systolic,
                              @RequestParam("diastolic") int diastolic,
                              @RequestParam("pulse") int pulse,
                              @RequestParam("addinfo") String addInfo) {
        medilogService.bloodPressure(userId, dateTime, systolic, diastolic, pulse, addInfo);
    }

    // http://localhost:8080/medilog/bloodsugar?userid=1&datetime=2021-02-04T16:20&bloodsugar=5,6&addinfo=test
    @PostMapping("bloodsugar")
    public void bloodPressure(@RequestParam("userid") int userId,
                              @RequestParam("datetime") LocalDateTime dateTime,
                              @RequestParam("bloodsugar") BigDecimal bloodSugar,
                              @RequestParam("addinfo") String addInfo) {
        medilogService.bloodSugar(userId, dateTime, bloodSugar, addInfo);
    }

    // http://localhost:8080/medilog/weight?userId=1&datetime=2021-02-04T16:20&weight=76&height=180&bmi=23,5&addinfo=test
    @PostMapping("weight")
    public void bloodPressure(@RequestParam("userid") String userId,
                              @RequestParam("datetime") LocalDateTime dateTime,
                              @RequestParam("weight") BigDecimal weight,
                              @RequestParam("height") BigDecimal height,
                              @RequestParam("bmi") BigDecimal bmi,
                              @RequestParam("addinfo") String addInfo) {
        medilogService.weight(userId, dateTime, weight, height, bmi, addInfo);
    }

    // http://localhost:8080/medilog/temperature?userId=1&datetime=2021-02-04T16:20&temp=37,6&addinfo=test
    @PostMapping("temperature")
    public void bodyTemp(@RequestParam("userid") String userId,
                         @RequestParam("datetime") LocalDateTime dateTime,
                         @RequestParam("temp") BigDecimal temp,
                         @RequestParam("addinfo") String addInfo) {
        medilogService.bodyTemp(userId, dateTime, temp, addInfo);
    }

}
