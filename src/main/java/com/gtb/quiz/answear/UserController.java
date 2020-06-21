package com.gtb.quiz.answear;

import java.util.List;

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
    public User createCar(@PathVariable("id") long userId) {
        return userService.getUserById(userId);
    }

//    @GetMapping(value = "/get")
//    public List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
}