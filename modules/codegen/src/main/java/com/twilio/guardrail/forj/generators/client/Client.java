package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.Node;
import io.vavr.collection.Seq;

public interface Client {
    Seq<String> getPackage();
    String getClientName();
    Seq<Node> getLines();
}
