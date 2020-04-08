package com.dadong.feign;

import com.dadong.feign.fallback.UserClientFallback;
import com.dadong.feign.util.FeignCongfig;
import com.dadong.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/***
 * 通过feign远程调用服务的接口
 */
@FeignClient(value = "user-provider", //开启feign 并指定服务名
        fallback = UserClientFallback.class, // 开启feign服务降级，指定降级类
        configuration = FeignCongfig.class) // 指定feign日志级别配置类
public interface UserClient {

    /***
     * 通过feign来进行远程服务调用
     * 根据Id查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/findById/{id}")
    User findByUserId(@PathVariable(value = "id") Integer id);
}
