package com.maple.gani.reference.provider;

import com.maple.gani.common.Result;
import com.maple.gani.common.ServiceTemplate;
import com.maple.gani.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController("/gani-admin")
public class TestProvider {

    @Resource
    private ServiceTemplate serviceTemplate;

    @Resource
    private TestService testService;

    @PostMapping("/test")
    public Result<Void> test() {
        return serviceTemplate.execute(result -> {
            testService.test();
        }, (result, ex) -> {
            return handleException(result, ex);
        });
    }

    private <T> boolean handleException(Result<T> r, Exception e) {
        r.setStatus(200);
        r.setMessage("测试");
        return true;

    }
}
