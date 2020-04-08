package com.dadong.controller;

import com.dadong.feign.UserClient;
import com.dadong.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/feign")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    @RequestMapping(value = "/{id}")
    public User queryById(@PathVariable(value = "id")Integer id){
        return userClient.findByUserId(id);
    }
}
