package com.maple.gani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class GaniUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaniUserApplication.class, args);
        System.out.println("----------gani-user启动成功！");
    }

}
