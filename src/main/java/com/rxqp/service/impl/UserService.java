package com.rxqp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rxqp.entity.bo.User;
import com.rxqp.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
    private UserMapper userMapper;
   
    public List<User> likeName(String name){
        return userMapper.likeName(name);
    }
}
