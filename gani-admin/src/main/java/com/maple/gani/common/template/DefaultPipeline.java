package com.maple.gani.common.template;

import java.util.LinkedList;
import java.util.List;

/**
 * 执行链
 */
public class DefaultPipeline implements Pipeline {

    private List<Filter> filters = new LinkedList<>();

    public DefaultPipeline setFilters(List<Filter> filters) {
        return clearFilters().addFilters(filters);
    }

    public DefaultPipeline addFilters(List<Filter> filters) {
        if (filters != null) {
            filters.forEach(this::addFilter);
        }
        return this;
    }

    public DefaultPipeline addFilter(Filter filter) {
        filters.add(0, filter);
        return this;
    }

    public DefaultPipeline clearFilters() {
        filters.clear();
        return this;
    }

    @Override
    public <V> V execute(Action<V> action, Object... args) throws Exception {
        return null;
    }

    private <V> Action<V> buildChain(Action<V> action) {
        Action<V> last = action;
        for (Filter filter : filters) {
            Action<V> next = last;
            last = args -> filter.execute(next, args);
        }
        return last;
    }
}
