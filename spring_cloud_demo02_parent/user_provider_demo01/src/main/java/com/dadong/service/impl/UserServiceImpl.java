package com.dadong.service.impl;

import com.dadong.dao.UserDao;
import com.dadong.pojo.User;
import com.dadong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /***
     * 根据Id查询用户
     * @param id
     * @return
     */
    @Override
    public User findByUserId(Integer id) {

        return userDao.findById(id).get();
    }


}
