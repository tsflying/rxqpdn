package com.rxqp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rxqp.entity.User;
import com.rxqp.service.UserService;

@RestController
public class UserController {

	@Autowired
    private UserService demoService;
   
    @RequestMapping("/likeName")
    public List<User> likeName(String name){
       return demoService.likeName(name);
    }
}
