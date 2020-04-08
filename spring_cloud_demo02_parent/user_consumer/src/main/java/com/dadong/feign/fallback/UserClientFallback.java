package com.dadong.feign.fallback;

import com.dadong.feign.UserClient;
import com.dadong.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    /***
     * 服务降级处理方法
     * @param id
     * @return
     */
    @Override
    public User findByUserId(Integer id) {
        User user = new User();
        user.setUsername("Fallback,服务降级。。。。。。");
        return user;
    }
}
