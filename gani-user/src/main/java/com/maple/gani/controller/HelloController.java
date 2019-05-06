package com.maple.gani.controller;

import com.maple.gani.common.Result;
import com.maple.gani.reference.consumer.TestClient;
import com.maple.gani.reference.consumer.dto.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    TestClient testClient;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        Result<String> result = testClient.test();
        return result.getData();
    }

    @GetMapping("/feign-consumer1")
    public User helloConsumer1() {
        Result<User> result = testClient.test1();
        return result.getData();
    }

    @GetMapping("/feign-consumer2")
    public String helloConsumer2() {
        Result<String> result = testClient.test2();
        return result.getData();
    }
}
