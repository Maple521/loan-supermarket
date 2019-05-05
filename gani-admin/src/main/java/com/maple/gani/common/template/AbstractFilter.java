package com.maple.gani.common.template;

public abstract class AbstractFilter implements Filter{

    protected abstract void beforeExecute(Object...args) throws Exception;

    protected abstract void afterExecute(Object...args) throws Exception;

    @Override
    public <V> V execute(Action<V> action,Object...args) throws Exception{
        beforeExecute(args);
        V result = action.execute(args);
        afterExecute(args);
        return result;
    }
}
