package com.dadong.controller;

import com.dadong.feign.UserClient;
import com.dadong.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "consumer")
@DefaultProperties(defaultFallback = "defaultFailBack")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    @HystrixCommand
    @GetMapping(value = "/{id}")
    public User queryById(@PathVariable(value = "id")Integer id){
        String url = "http://user-provider/user/findById"+id;
        //return restTemplate.getForObject(url,User.class);

        // 获取指定实例
        // List<ServiceInstance> instances = discoveryClient.getInstances("user-provider");
        // 获取第1个实例对象
        // ServiceInstance serviceInstance = instances.get(0);
        // 拼接服务地址
        //String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "demo02/user/findById" + id;
        return restTemplate.getForObject(url,User.class);
    }

    /***
     * 局部降级处理
     * 需要需要降级的方法向添加 @HystrixCommand 注解，并在里面指定降级方法
     * @param id
     * @return
     */
    public User failBack(Integer id){
        User user = new User();
        user.setUsername("服务降级，默认处理！");
        return user;
    }

    /***
     * 全局降级处理
     * 需要把降级方法中 @HystrixCommand 注解后相关内容去掉
     * 并在雷伤添加 @DefaultProperties 注解，病指定降级方法
     * @return
     */
    public User defaultFailBack(){
        User user = new User();
        user.setUsername("Default-服务降级，默认处理!!!");
        return user;
    }
}
