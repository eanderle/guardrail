package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.twilio.guardrail.Context;
import com.twilio.guardrail.forj.terms.RouteMeta;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

public class AHCClientGenerator extends ClientGenerator {
    public AHCClientGenerator(
            final Context context,
            final Seq<ImportDeclaration> frameworkImports,
            final Seq<String> schemes,
            final Option<String> host,
            final Option<String> basePath,
            final Seq<Tuple2<Seq<String>, Seq<RouteMeta>>> groupedRoutes) {
        super(context, frameworkImports, schemes, host, basePath, groupedRoutes);
    }

    @Override
    public Client buildClient(
            final String clientName,
            final Option<String> tracingName,
            final Seq<Seq<Parameter>> ctorArgs,
            final Seq<MethodDeclaration> supportDefinitions) {
        return new Client() {
            @Override
            public Seq<String> getPackage() {
                return List.of("com", "twilio", "generated", "client");
            }

            @Override
            public String getClientName() {
                return "AHCClient";
            }

            @Override
            public Seq<Node> getLines() {
                final CompilationUnit compilationUnit = new CompilationUnit(getPackage().mkString("."));
                final ClassOrInterfaceDeclaration myClass = compilationUnit
                    .addClass(getClientName())
                    .setPublic(true);

                final MethodDeclaration method = myClass
                    .addMethod("hello")
                    .setPublic(true);

                final BlockStmt methodBody = method
                    .createBody()
                    .addStatement("System.out.println(\"Hello World!\");");

                return List.ofAll(compilationUnit.getChildNodes());
            }
        };
    }
}
