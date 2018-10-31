package com.twilio.guardrail.forj.generators.client;

import com.twilio.guardrail.Context;
import io.vavr.collection.List;
import io.vavr.control.Option;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AHCClientGeneratorTest {

    private AHCClientGenerator generator;

    @BeforeEach
    public void setUp() {
        this.generator = new AHCClientGenerator(
            Context.empty(),
            List.empty(),
            List.empty(),
            Option.of("http://localhost:8080"),
            Option.of("v1/myService"),
            List.empty());
    }

    @Test
    public void basicTest() {
        System.out.println(this.generator
            .buildClient(
                "lolClient",
                Option.none(),
                List.empty(),
                List.empty())
            .getLines());
    }
}
