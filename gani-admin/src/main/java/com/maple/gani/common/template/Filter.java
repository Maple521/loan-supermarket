package com.maple.gani.common.template;

public interface Filter {

    <V> V execute(Action<V> action, Object... args) throws Exception;

}
