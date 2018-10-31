package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.CompilationUnit;
import io.vavr.collection.Seq;

public interface Client {
    Seq<String> getPackage();
    String getClientName();
    CompilationUnit getLines();
}
