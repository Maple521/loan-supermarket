package com.maple.gani.common;

import com.maple.gani.common.Result;

public interface ServiceAction<T> {

    void execute(Result<T> result) throws Exception;
}
