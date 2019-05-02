package com.maple.gani.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("gani-admin")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
