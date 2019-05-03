package com.maple.gani.common;

import com.maple.gani.service.TestService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class ServiceTemplate {

    @Resource
    TestService testService;

    /*public <T,U, R> Result<T> execute(BiFunction<T,U, R> function, Exception e){

        function.apply();

        Result<T> result = new Result<T>();
        return result;

    }*/
}


