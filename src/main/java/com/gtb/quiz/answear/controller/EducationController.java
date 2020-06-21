package com.gtb.quiz.answear.controller;

import com.gtb.quiz.answear.model.CreateAccountRequest;
import com.gtb.quiz.answear.model.CreateEducationRequest;
import com.gtb.quiz.answear.model.Education;
import com.gtb.quiz.answear.model.User;
import com.gtb.quiz.answear.service.EducationService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@ResponseBody
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

//    @PostMapping(value = "/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void register(@RequestBody user) {
//        EducationService.register(user);
//    }

    @GetMapping(value = "/users/{id}/educations")
    public List<Education> getEducationInfo(@PathVariable("id") long userId) {
        return educationService.getInfoByUserId(userId);
    }

    @GetMapping(value = "/educations/get")
    public Map<Long,List<Education>> getAllInfo() {
        return educationService.getAllInfo();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users/{id}/educations")
    public void createEducation(@RequestBody CreateEducationRequest createEducationRequest) {
        educationService.creatEducationInfo(createEducationRequest);
    }


//    @GetMapping(value = "/get")
//    public List<User> getAllUsers() {
//        return EducationService.getAllUsers();
//    }
}