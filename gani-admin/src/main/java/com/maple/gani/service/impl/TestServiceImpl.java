package com.maple.gani.service.impl;

import com.maple.gani.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "王弘博测试Feign";
    }
}
