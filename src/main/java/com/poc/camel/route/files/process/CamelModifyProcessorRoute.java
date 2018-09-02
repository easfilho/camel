package com.poc.camel.route.files.process;

import com.poc.camel.processors.CamelFileExampleProcessor;
import org.apache.camel.builder.RouteBuilder;

public class CamelModifyProcessorRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:data/input?noop=true")
                .log("Read file is ${body} and headers are ${headers}")
                .process(new CamelFileExampleProcessor())
                .to("file:data/output?fileName=output.txt");
    }
}
