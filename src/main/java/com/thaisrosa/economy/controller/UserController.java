package com.thaisrosa.economy.controller;

import com.thaisrosa.economy.domain.User;
import com.thaisrosa.economy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    private User login(@RequestBody User user) {
        return userService.login(user.getEmail(), user.getSenha());
    }

    @PostMapping("/create")
    @ResponseBody
    private User create(@RequestBody User user) {
        return userService.create(user);
    }
}
