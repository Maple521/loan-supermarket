package com.maple.gani.common;


import com.maple.gani.common.template.Action;
import com.maple.gani.common.template.DefaultPipeline;
import com.maple.gani.common.template.Filter;
import com.maple.gani.common.template.Pipeline;

import java.util.List;

public class ServiceTemplate {

    private Pipeline pipeline = new DefaultPipeline();

    public ServiceTemplate setInterceptors(List<ServiceInterceptor> interceptors) {
        pipeline.clearFilters();
        return addInterceptors(interceptors);
    }

    public ServiceTemplate addInterceptors(List<ServiceInterceptor> interceptors) {
        if (interceptors != null) {
            interceptors.forEach(this::addInterceptor);
        }
        return this;
    }

    public ServiceTemplate addInterceptor(ServiceInterceptor interceptor) {
        pipeline.addFilter(new Filter() {
            @Override
            public <T> T execute(Action<T> action, Object... args) throws Exception {
                interceptor.intercept(result -> {
                    action.execute(result);
                }, (Result<T>) args[0]);
                return null;
            }
        });
        return this;
    }

    public <T> Result<T> safeExecute(ServiceAction<T> action) throws Exception {
        return safeExecute(action, null);
    }

    public <T> Result<T> safeExecute(ServiceAction<T> action, ExceptionHandler<T> handler) throws Exception {
        Result<T> result = new Result<>();
        try {
            pipeline.execute((args) -> {
                action.execute((Result<T>) args[0]);
                return null;
            }, result);
        } catch (Exception e) {
            if (handler != null && handler.handle(result.reset(), e)) {
                return result;
            }
            throw e;
        }
        return result;
    }

    public <T> Result<T> execute(ServiceAction<T> action) {
        return execute(action, null);
    }

    /**
     * @param action
     * @param handler
     * @return
     */
    public <T> Result<T> execute(ServiceAction<T> action, ExceptionHandler<T> handler) {
        try {
            return safeExecute(action, handler);
        } catch (Exception e) {
            throw (RuntimeException) e;
        }
    }

    public interface ExceptionHandler<T> {

        boolean handle(Result<T> result, Exception e);

    }
}
