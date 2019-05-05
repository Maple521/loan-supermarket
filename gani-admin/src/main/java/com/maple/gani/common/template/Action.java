package com.maple.gani.common.template;

public interface Action<V> {

    V execute(Object...args) throws Exception;
}
