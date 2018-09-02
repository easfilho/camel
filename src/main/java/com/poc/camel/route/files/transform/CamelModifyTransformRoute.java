package com.poc.camel.route.files.transform;

import org.apache.camel.builder.RouteBuilder;

public class CamelModifyTransformRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:tranformInput")
                .transform(body().regexReplaceAll(",", "*"))
                .to("file:data/output?fileName=output.txt");
    }
}
