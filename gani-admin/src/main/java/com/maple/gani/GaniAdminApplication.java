package com.maple.gani;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GaniAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GaniAdminApplication.class, args);
        System.out.println("----------gani-admin启动成功！");
    }

}
