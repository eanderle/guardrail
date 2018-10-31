package com.twilio.guardrail.forj.generators.client;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.StringLiteralExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import io.vavr.collection.List;
import io.vavr.collection.Seq;
import io.vavr.control.Option;

import java.util.function.Consumer;

import static java.util.Objects.requireNonNull;

class AHCClient implements Client {
    private final Option<String> host;
    private final Option<String> basePath;

    public AHCClient(final Option<String> host, final Option<String> basePath) {
        this.host = requireNonNull(host);
        this.basePath = requireNonNull(basePath);
    }

    @Override
    public Seq<String> getPackage() {
        return List.of("com", "twilio", "generated", "client");
    }

    @Override
    public String getClientName() {
        return "AHCClient";
    }

    @Override
    public CompilationUnit getLines() {
        final CompilationUnit compilationUnit = new CompilationUnit(getPackage().mkString("."));
        final ClassOrInterfaceDeclaration myClass = compilationUnit
            .addClass(getClientName())
            .setPublic(true);

        this.host.forEach(createOptionalConst(myClass, "DEFAULT_HOST"));
        this.basePath.forEach(createOptionalConst(myClass, "DEFAULT_BASE_PATH"));

        final MethodDeclaration method = myClass
            .addMethod("hello")
            .setPublic(true);

        final BlockStmt methodBody = method
            .createBody()
            .addStatement("System.out.println(\"Hello World!\");");

        return compilationUnit;
    }

    private Consumer<String> createOptionalConst(final ClassOrInterfaceDeclaration myClass, final String name) {
        return val -> myClass.addFieldWithInitializer(
            String.class,
            name,
            new StringLiteralExpr(val),
            Modifier.PUBLIC,
            Modifier.STATIC);
    }
}
