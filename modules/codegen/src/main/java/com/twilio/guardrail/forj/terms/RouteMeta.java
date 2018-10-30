package com.twilio.guardrail.forj.terms;

import io.swagger.models.HttpMethod;
import io.swagger.models.Operation;

import static java.util.Objects.requireNonNull;

public class RouteMeta {
    private final String path;
    private final HttpMethod method;
    private final Operation operation;

    public RouteMeta(final String path, final HttpMethod method, final Operation operation) {
        this.path = requireNonNull(path);
        this.method = requireNonNull(method);
        this.operation = requireNonNull(operation);
    }
}
