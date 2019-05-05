package com.maple.gani.common;

public interface ServiceInterceptor {

    <T> void intercept(ServiceAction<T> action, Result<T> result) throws Exception;
}
