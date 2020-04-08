package com.dadong.service;

import com.dadong.pojo.User;

import java.util.Optional;

public interface UserService {

    /***
     * 根据ID查询用户
     * @param id
     * @return
     */
   User findByUserId(Integer id);
}
