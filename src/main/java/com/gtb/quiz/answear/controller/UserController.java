package com.gtb.quiz.answear.controller;

import java.util.List;

import com.gtb.quiz.answear.model.CreateAccountRequest;
import com.gtb.quiz.answear.model.User;
import com.gtb.quiz.answear.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping(value = "/register")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void register(@RequestBody user) {
//        userService.register(user);
//    }

    @GetMapping(value = "/users/{id}")
    public User getUsersInfo(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/users/get")
    public List<User> getUsersInfo()
    {
        return userService.getAllUsers();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/users")
    public void createUser(@RequestBody CreateAccountRequest createAccountRequest) {
        userService.createUser(createAccountRequest);
    }

//    @GetMapping(value = "/get")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
}