package com.maple.gani.reference.provider;

import com.maple.gani.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestProvider{

    @Resource
    private ServiceTemplate serviceTemplate;

    @Resource
    private TestService testService;

    /*@GetMapping("/test")
    public String test() {
        return testService.test();
    }*/
    @GetMapping("/test")
    public Result<String> test() {
        return serviceTemplate.execute(result -> {
            result.setData(testService.test());
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
