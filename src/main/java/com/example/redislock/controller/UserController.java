package com.example.redislock.controller;

import com.example.redislock.dao.User;
import com.example.redislock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author admin
 * @date 2021/12/9 14:21
 */
@RestController
@RequestMapping("/lock")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping ("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
