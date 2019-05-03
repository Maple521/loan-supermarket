package com.maple.gani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class GaniAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaniAdminApplication.class, args);
        System.out.println("----------gani-admin启动成功！");
    }

}
