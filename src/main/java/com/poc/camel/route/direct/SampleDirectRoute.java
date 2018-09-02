package com.poc.camel.route.direct;

import org.apache.camel.builder.RouteBuilder;

public class SampleDirectRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:sampleInput")
                .log("Mensagem Recebida: ${body} Headers: ${headers}")
                .to("file:data/sampledata?fileName=output.txt");
    }
}
