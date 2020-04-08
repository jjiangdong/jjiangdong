package com.dadong.controller;

import com.dadong.pojo.User;
import com.dadong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    /***
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/findById{id}")
    public User findByUserId(@PathVariable(value = "id") Integer id){
        User user = userService.findByUserId(id);
        user.setUsername(user + "   user-provider-demo01");
        return user;
    }
}
