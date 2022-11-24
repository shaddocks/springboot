package com.spring.study.controller;

import com.spring.study.bean.User;
import com.spring.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return userService.getUser();
    }
}
