package com.maple.gani.reference.provider;

import com.maple.gani.common.Result;
import com.maple.gani.common.ServiceTemplate;
import com.maple.gani.reference.provider.dto.User;
import com.maple.gani.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/admin")
public class TestProvider {

    @Resource
    private ServiceTemplate serviceTemplate;

    @Resource
    private TestService testService;

    @GetMapping("/test")
    public Result<String> test() {
        return serviceTemplate.execute(result -> {
            result.setData(testService.test());
        }, (result, ex) -> {
            return handleException(result, ex);
        });
    }

    @GetMapping("/test1")
    Result<User> test1() {
        return serviceTemplate.execute(result -> {
            result.setData(testService.test1());
        }, (result, ex) -> {
            return handleException(result, ex);
        });
    }

    @GetMapping("/test2")
    Result<String> test2() {
        return serviceTemplate.execute(result -> {
            result.setData(testService.test2());
        }, (result, ex) -> {
            return handleException(result, ex);
        });
    }

    private <T> boolean handleException(Result<T> r, Exception e) {
        r.setStatus(2000);
        r.setMessage("测试");
        return false;
    }
}
