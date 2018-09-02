package com.poc.camel.route.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleMockRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
            .log("Body: ${body} Headers: ${headers}")
            .to("mock:output");
    }
}
