package com.maple.gani.reference.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "gani-admin")
public interface TestClient {

    @GetMapping("/test")
    Result<String> test();
    //String test();
}
