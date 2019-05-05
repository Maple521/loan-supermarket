package com.maple.gani.controller;

import com.maple.gani.common.ServiceTemplate;
import com.maple.gani.reference.consumer.TestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

@RestController
public class HelloController {

    private final Logger logger = Logger.getLogger("helloController");

    @Resource
    private DiscoveryClient client;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String index() {
        List<ServiceInstance> instances = client.getInstances("gani-admin");
        for (ServiceInstance instance : instances) {
            logger.info("/hello，host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
        }
        return "Hello World";
    }
}
