package org.econtact.data.filter.visitor;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.From;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.Map;

public class VisitorContext {

    private final CriteriaBuilder cb;
    private final Root root;
    private final Map<String, From> fromMap;
    private final Map<String, Object> params;
    private int paramIndex = 0;

    public VisitorContext(final CriteriaBuilder cb, final Root root) {
        this.cb = cb;
        this.root = root;
        this.fromMap = new HashMap<>();
        this.params = new HashMap<>();
    }

    public CriteriaBuilder getCriteriaBuilder() {
        return cb;
    }

    public Root getRoot() {
        return root;
    }

    public Map<String, From> getFromMap() {
        return fromMap;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public ParameterExpression createFindParam(final Object value) {
        final String paramName = addParameter(value);
        return cb.parameter(value.getClass(), paramName);
    }

    public ParameterExpression createFindParam(final Class<?> paramClass, final Object value) {
        final String paramName = addParameter(value);
        return cb.parameter(paramClass, paramName);
    }

    private String addParameter(Object value) {
        final String key = "par_" + paramIndex++;
        params.put(key, value);
        return key;
    }
}
