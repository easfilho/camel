package com.poc.camel.route.files;

import org.apache.camel.builder.RouteBuilder;

public class CopyFilesRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .to("file:data/output");
    }
}
