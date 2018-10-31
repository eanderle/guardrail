package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.twilio.guardrail.Context;
import com.twilio.guardrail.forj.terms.RouteMeta;
import io.vavr.Tuple2;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

import static java.util.Objects.requireNonNull;

public abstract class ClientGenerator {
    final Context context;
    final Seq<ImportDeclaration> frameworkImports;
    final Seq<String> schemes;
    final Option<String> host;
    final Option<String> basePath;
    final Seq<Tuple2<Seq<String>, Seq<RouteMeta>>> groupedRoutes;

    public ClientGenerator(
            final Context context,
            final Seq<ImportDeclaration> frameworkImports,
            final Seq<String> schemes,
            final Option<String> host,
            final Option<String> basePath,
            final Seq<Tuple2<Seq<String>, Seq<RouteMeta>>> groupedRoutes) {
        this.context = requireNonNull(context);
        this.frameworkImports = requireNonNull(frameworkImports);
        this.schemes = requireNonNull(schemes);
        this.host = requireNonNull(host);
        this.basePath = requireNonNull(basePath);
        this.groupedRoutes = requireNonNull(groupedRoutes);
    }

    public abstract Client buildClient(
        final String clientName,
        final Option<String> tracingName,
        final Seq<Seq<Parameter>> ctorArgs,
        final Seq<MethodDeclaration> supportDefinitions);


    public Context getContext() {
        return context;
    }

    public Seq<ImportDeclaration> getFrameworkImports() {
        return frameworkImports;
    }

    public Seq<String> getSchemes() {
        return schemes;
    }

    public Option<String> getHost() {
        return host;
    }

    public Option<String> getBasePath() {
        return basePath;
    }

    public Seq<Tuple2<Seq<String>, Seq<RouteMeta>>> getGroupedRoutes() {
        return groupedRoutes;
    }
}
