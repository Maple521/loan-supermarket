package com.maple.gani.controller;

import com.maple.gani.common.Result;
import com.maple.gani.reference.consumer.TestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Value("${whb}")
    private String whb;

    @Resource
    TestClient testClient;

    @RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        System.out.println("-------:" + whb);
        Result<String> result = testClient.test();
        return result.getData();
    }
}
