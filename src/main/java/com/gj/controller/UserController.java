package com.gj.controller;

import com.gj.pojo.User;
import com.gj.pojo.dto.ResponseMessage;
import com.gj.pojo.dto.UserDto;


import com.gj.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PostMapping
    public ResponseMessage add(@RequestBody UserDto user) {
        User userNew = userService.add(user);
        return ResponseMessage.success(userNew);
    }

    @GetMapping("/{userId}")
    public ResponseMessage get(@PathVariable Integer userId) {
        User userNew = userService.getUser(userId);
        return ResponseMessage.success(userNew);
    }
}
