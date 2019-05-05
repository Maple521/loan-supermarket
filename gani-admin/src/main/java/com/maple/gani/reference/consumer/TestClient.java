package com.maple.gani.reference.consumer;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "gani-user")
public interface TestClient {


}
