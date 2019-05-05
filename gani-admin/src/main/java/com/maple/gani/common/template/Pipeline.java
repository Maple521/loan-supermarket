package com.maple.gani.common.template;

import java.util.List;

public interface Pipeline {

    Pipeline addFilters(List<Filter> filters);

    Pipeline addFilter(Filter filter);

    Pipeline clearFilters();

    <V> V execute(Action<V> action, Object... args) throws Exception;
}
