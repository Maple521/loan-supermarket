package com.maple.gani.service.impl;

import com.maple.gani.reference.provider.dto.User;
import com.maple.gani.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public String test() {
        return "王弘博测试Feign";
    }

    @Override
    public User test1() {
        User user = new User();
        user.setName("王弘博");
        user.setPhone("15155771517");
        return user;
    }

    @Override
    public String test2() {
        return "爱你一万年";
    }
}
