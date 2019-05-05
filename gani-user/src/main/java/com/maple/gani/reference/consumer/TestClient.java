package com.maple.gani.reference.consumer;

import com.maple.gani.common.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "gani-admin")
public interface TestClient {

    @PostMapping("/test")
    Result<Void> smssend();
}
