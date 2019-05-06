package com.maple.gani.reference.consumer;

import com.maple.gani.common.Result;
import com.maple.gani.reference.consumer.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gani-admin")
public interface TestClient {

    @GetMapping("/test")
    Result<String> test();

    @GetMapping("/test1")
    Result<User> test1();

    @GetMapping("/test2")
    Result<String> test2();
    //String test();
}
