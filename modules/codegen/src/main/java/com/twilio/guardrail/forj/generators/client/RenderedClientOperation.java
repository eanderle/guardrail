package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.body.MethodDeclaration;
import io.vavr.collection.Seq;

import static java.util.Objects.requireNonNull;

public class RenderedClientOperation {
    private final MethodDeclaration clientOperation;
    private final Seq<MethodDeclaration> supportDefinitions;

    public RenderedClientOperation(final MethodDeclaration clientOperation, final Seq<MethodDeclaration> supportDefinitions) {
        this.clientOperation = requireNonNull(clientOperation);
        this.supportDefinitions = requireNonNull(supportDefinitions);
    }
}
